package nl.novi.loahy.controllers;

import nl.novi.loahy.dtos.ProductDto;
import nl.novi.loahy.dtos.WishlistDto;
import nl.novi.loahy.services.WishlistProductService;
import nl.novi.loahy.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/wishlists")
public class WishlistController {

    private final WishlistService wishlistService;

    private final WishlistProductService wishlistProductService;

    @Autowired
    public WishlistController(WishlistService wishlistService, WishlistProductService wishlistProductService) {
        this.wishlistService = wishlistService;
        this.wishlistProductService = wishlistProductService;
    }



    @PostMapping(value = "/create")
    public ResponseEntity<WishlistDto> createWishlist(@RequestBody WishlistDto dto) {
        WishlistDto dto1 = wishlistService.createWishlist(dto);

        return ResponseEntity.created(null).body((dto1));
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteWishlist(@PathVariable("id") Integer wishlistId) {

        wishlistService.deleteWishlistById(wishlistId);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/products/{wishlistId}")
    public Collection<ProductDto> getProductsByWishlistId(@PathVariable("wishlistId") Integer wishlistId) {
        return wishlistProductService.getWishlistProductsByWishlistId(wishlistId);
    }
}
