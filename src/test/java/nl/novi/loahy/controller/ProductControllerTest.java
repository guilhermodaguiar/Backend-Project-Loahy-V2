package nl.novi.loahy.controller;

import nl.novi.loahy.controllers.ProductController;
import nl.novi.loahy.dtos.ProductInputDto;
import nl.novi.loahy.models.Product;
import nl.novi.loahy.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    @DisplayName("Should return all products when no parameters are passed")
    void getProductsWhenNoParametersArePassed() {
        var product = new Product();
        product.setProductId(1);
        product.setProductName("Test");
        product.setProductDescription("Test");
        product.setProductQuantity(100);
        product.setProductDescription("Test");
        product.setProductPrice(1.0);

        var products = List.of(product);

        when(productService.getProducts()).thenReturn(products);

        var result = productController.getAllProducts();

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should create a product when the product is valid")
    void createProductWhenProductIsValid() {
        ProductInputDto productInputDto = new ProductInputDto();
        productInputDto.setProductName("test");
        productInputDto.setProductInformation("test");
        productInputDto.setProductPrice(1D);
        productInputDto.setProductQuantity(100);

        Product product = new Product();
        product.setProductName("test");
        product.setProductDescription("test");
        product.setProductPrice(1D);
        product.setProductQuantity(100);


        when(productService.createProduct(any())).thenReturn(product);

        ResponseEntity<Object> result = productController.createProduct(productInputDto);

        assertEquals(productInputDto.getProductName(), result.getProductName());
    }

    @Test
    @DisplayName("Should throw an exception when the product is invalid")
    void createProductWhenProductIsInvalidThenThrowException() {
        ProductInputDto productInputDto = new ProductInputDto();
        productInputDto.setProductName("");
        productInputDto.setProductInformation("");
        productInputDto.setProductPrice(0D);
        productInputDto.setProductQuantity(10);

        assertThrows(
                NullPointerException.class,
                () -> productController.createProduct(productInputDto));
    }
}