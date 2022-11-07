package nl.novi.loahy.controllers;

import nl.novi.loahy.services.WishlistProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
