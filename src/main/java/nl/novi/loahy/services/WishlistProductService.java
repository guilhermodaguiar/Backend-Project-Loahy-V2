package nl.novi.loahy.services;

import nl.novi.loahy.dtos.ProductDto;
import nl.novi.loahy.dtos.WishlistDto;
import nl.novi.loahy.exceptions.ProductNotFoundException;
import nl.novi.loahy.exceptions.WishlistNotFoundException;
import nl.novi.loahy.models.Product;
import nl.novi.loahy.models.Wishlist;
import nl.novi.loahy.models.WishlistProduct;
import nl.novi.loahy.models.WishlistProductKey;
import nl.novi.loahy.repositories.ProductRepository;
import nl.novi.loahy.repositories.WishlistProductRepository;
import nl.novi.loahy.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class WishlistProductService {

    private final WishlistRepository wishlistRepository;

    private final ProductRepository productRepository;

    private final WishlistProductRepository wishlistProductRepository;

    @Autowired
    public WishlistProductService(WishlistRepository wishlistRepository, ProductRepository productRepository,
                                  WishlistProductRepository wishlistProductRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
        this.wishlistProductRepository = wishlistProductRepository;
    }

    public Collection<WishlistDto> getWishlistProductsByProductId(Integer productId) {
        Collection<WishlistDto> wishlistDtos = new HashSet<>();
        Collection<WishlistProduct> wishlistProducts = wishlistProductRepository.findAllByProduct_ProductId(productId);
        for (WishlistProduct wishlistProduct : wishlistProducts) {
            Wishlist wishlist = wishlistProduct.getWishlist();
            WishlistDto wishlistDto = new WishlistDto();

            wishlist.setWishlistId(wishlistDto.wishlistId);

            wishlistDtos.add(wishlistDto);
        }
        return wishlistDtos;
    }

    public Collection<ProductDto> getWishlistProductsByWishlistId(Integer wishlistId) {
        Collection<ProductDto> productDtos = new HashSet<>();
        Collection<WishlistProduct> wishlistProducts = wishlistProductRepository.findAllByWishlist_WishlistId(wishlistId);
        for (WishlistProduct wishlistProduct : wishlistProducts) {
            Product product = wishlistProduct.getProduct();
            var productDto = new ProductDto();

            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());

            productDtos.add(productDto);
        }
        return productDtos;
    }


    public WishlistProductKey addWishlistProduct(Integer wishlistId, Integer productId) {
        var wishlistProduct = new WishlistProduct();
        if (!wishlistRepository.existsById(wishlistId)) {
            throw new WishlistNotFoundException(wishlistId);
        }
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (!productRepository.existsById(productId)) {
            throw new ProductNotFoundException(productId);
        }
        Product product = productRepository.findById(productId).orElse(null);
        wishlistProduct.setWishlist(wishlist);
        wishlistProduct.setProduct(product);
        WishlistProductKey id = new WishlistProductKey(wishlistId, productId);
        wishlistProduct.setId(id);
        wishlistProductRepository.save(wishlistProduct);
        return id;
    }
}
