package nl.novi.loahy.services;

import nl.novi.loahy.dtos.ProductDto;
import nl.novi.loahy.dtos.ShoppingCartDto;
import nl.novi.loahy.exceptions.ProductNotFoundException;
import nl.novi.loahy.exceptions.ShoppingCartNotFoundException;
import nl.novi.loahy.models.Product;
import nl.novi.loahy.models.ShoppingCart;
import nl.novi.loahy.models.ShoppingCartProduct;
import nl.novi.loahy.models.ShoppingCartProductKey;
import nl.novi.loahy.repositories.ProductRepository;
import nl.novi.loahy.repositories.ShoppingCartProductRepository;
import nl.novi.loahy.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ShoppingCartProductService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final ProductRepository productRepository;

    private final ShoppingCartProductRepository shoppingCartProductRepository;

    public ShoppingCartProductService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository
            , ShoppingCartProductRepository shoppingCartProductRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.shoppingCartProductRepository = shoppingCartProductRepository;
    }


    public Collection<ShoppingCartDto> getShoppingCartProductsByProductId(Integer productId) {
        Collection<ShoppingCartDto> shoppingCartDtos = new HashSet<>();
        Collection<ShoppingCartProduct> shoppingCartProducts = shoppingCartProductRepository.findAllByProduct_ProductId(productId);
        for (ShoppingCartProduct shoppingCartProduct : shoppingCartProducts) {
            ShoppingCart shoppingCart = shoppingCartProduct.getShoppingCart();
            ShoppingCartDto shoppingCartDto = new ShoppingCartDto();

            shoppingCart.setShoppingCartId(shoppingCartDto.shoppingCartId);

            shoppingCartDtos.add(shoppingCartDto);
        }
        return shoppingCartDtos;
    }

    public Collection<ProductDto> getShoppingCartProductsByShoppingCartId(Integer wishlistId) {
        Collection<ProductDto> productDtos = new HashSet<>();
        Collection<ShoppingCartProduct> shoppingCartProducts = shoppingCartProductRepository.findAllByShoppingCart_ShoppingCartId(wishlistId);
        for (ShoppingCartProduct shoppingCartProduct : shoppingCartProducts) {
            Product product = shoppingCartProduct.getProduct();
            var productDto = new ProductDto();

            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setProductQuantity(product.getProductQuantity());

            productDtos.add(productDto);
        }
        return productDtos;
    }


    public ShoppingCartProductKey addShoppingCartProduct(Integer shoppingCartId, Integer productId) {
        var shoppingCartProduct = new ShoppingCartProduct();
        if (!shoppingCartRepository.existsById(shoppingCartId)) {
            throw new ShoppingCartNotFoundException(shoppingCartId);
        }
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).orElse(null);
        if (!productRepository.existsById(productId)) {
            throw new ProductNotFoundException(productId);
        }
        Product product = productRepository.findById(productId).orElse(null);
        shoppingCartProduct.setShoppingCart(shoppingCart);
        shoppingCartProduct.setProduct(product);
        ShoppingCartProductKey id = new ShoppingCartProductKey(shoppingCartId, productId);
        shoppingCartProduct.setId(id);
        shoppingCartProductRepository.save(shoppingCartProduct);
        return id;
    }
}
