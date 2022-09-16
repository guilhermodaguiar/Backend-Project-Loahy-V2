package nl.novi.loahy.controllers;

import nl.novi.loahy.service.WishlistProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wishlist-products")
public class WishlistProductController {
    private final WishlistProductService wishlistProductService;

    @Autowired
    public WishlistProductController(WishlistProductService wishlistProductService) {
        this.wishlistProductService = wishlistProductService;
    }

    @PostMapping(value = "/{wishlistId}/{productId}")
    public void addWishlistProduct(@PathVariable("wishlistId") Integer wishlistId, @PathVariable("productId") Integer productId) {
        wishlistProductService.addWishlistProduct(wishlistId, productId);
    }
}
