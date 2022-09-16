package nl.novi.loahy.controllers;

import nl.novi.loahy.dtos.ProductDto;
import nl.novi.loahy.dtos.ProductInputDto;
import nl.novi.loahy.dtos.WishlistDto;
import nl.novi.loahy.models.FileUploadResponse;
import nl.novi.loahy.service.ProductService;
import nl.novi.loahy.service.WishlistProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductService productService;
    private final ImageController imageController;

    private final WishlistProductService wishlistProductService;

    @Autowired
    public ProductController(ProductService productService, ImageController imageController, WishlistProductService wishlistProductService) {
        this.productService = productService;
        this.imageController = imageController;
        this.wishlistProductService = wishlistProductService;
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<ProductDto>> getAllProducts() {

        List<ProductDto> productsDto = productService.getAllProducts();

        return ResponseEntity.ok().body(productsDto);
    }

    @GetMapping(value="/{id}")
    @Transactional
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Integer productId) {

        ProductDto optionalProduct = productService.getProduct(productId);

        return ResponseEntity.ok().body(optionalProduct);

    }

    @PostMapping(value ="")
    ResponseEntity<Object>createProduct(@RequestBody ProductInputDto inputDto) {
        ProductDto productDto = productService.createProduct(inputDto);

        return ResponseEntity.created(null).body(productDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateProduct (@PathVariable("id") Integer productId, @RequestBody ProductInputDto inputDto) {

       ProductDto productDto = productService.updateProduct(productId, inputDto);

       return ResponseEntity.ok().body(productDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Integer productId) {

        productService.deleteProduct(productId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{id}/image")
    public void assignImageToProduct(@PathVariable("id") Integer productId,
                                     @RequestBody MultipartFile file) {

        FileUploadResponse productImage = imageController.singleFileUpload(file);

        productService.assignImageToProduct(productImage.getFileName(), productId);
    }

    @GetMapping("/wishlists/{productId}")
    public Collection<WishlistDto> getWishlistsByProductId(@PathVariable("productId") Integer productId){
        return wishlistProductService.getWishlistProductsByProductId(productId);
    }

}