package nl.novi.loahy.controllers;

import nl.novi.loahy.dtos.ProductDto;
import nl.novi.loahy.dtos.WishlistDto;
import nl.novi.loahy.service.WishlistProductService;
import nl.novi.loahy.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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

    @GetMapping(value = "")
    public ResponseEntity<List<WishlistDto>> getAllWishlists() {

        List<WishlistDto> wishlistDto = wishlistService.getAllWishlists();

        return ResponseEntity.ok().body(wishlistDto);
    }

//    @PostMapping(value = "")
//    public ResponseEntity<Object> createWishlist(@RequestBody WishlistInputDto wishlistInputDto) {
//
//        WishlistDto wishlistDto = wishlistService.createWishlist(wishlistInputDto);
//
//        return ResponseEntity.ok().body(wishlistDto);
//    }

    @PostMapping(value = "")
    public WishlistDto addWishlist(@RequestBody WishlistDto dto) {
        WishlistDto dto1 = wishlistService.addWishlist(dto);
        return dto1;
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteWishlist(@PathVariable("id") Integer wishlistId) {

        wishlistService.deleteWishlistById(wishlistId);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/products/{wishlistId}")
    public Collection<ProductDto> getProductsByWishlistId(@PathVariable("wishlistId") Integer wishlistId){
        return wishlistProductService.getWishlistProductsByWishlistId(wishlistId);
    }
}
