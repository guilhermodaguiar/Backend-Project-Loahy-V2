package nl.novi.loahy.services;

import nl.novi.loahy.dtos.ProductDto;
import nl.novi.loahy.dtos.WishlistDto;
import nl.novi.loahy.exceptions.ProductNotFoundException;
import nl.novi.loahy.exceptions.WishlistNotFoundException;
import nl.novi.loahy.models.Product;
import nl.novi.loahy.models.Wishlist;
import nl.novi.loahy.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.loahy.dtos.ProductDto.transferToDto;
import static nl.novi.loahy.dtos.WishlistDto.transferToWishlistDto;

@Service
public class WishlistService {
    
    private final WishlistRepository wishlistRepository;


    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }



    public WishlistDto createWishlist(WishlistDto wishlistDto) {


        Wishlist newWishlist =  transferToWishlist(wishlistDto);
        wishlistRepository.save(newWishlist);
        return transferToWishlistDto(newWishlist);
    }


    public WishlistDto updateWishlist(Integer wishlistId, WishlistDto wishlistDto) {
        if (wishlistRepository.findById(wishlistId).isPresent()) {

            Wishlist wishlist = wishlistRepository.findById(wishlistId).get();

            Wishlist wishlist1 = transferToWishlist(wishlistDto);
            wishlist1.setWishlistName(wishlist.getWishlistName());

            wishlistRepository.save(wishlist1);

            return transferToWishlistDto(wishlist1);
        } else {
            throw new WishlistNotFoundException(wishlistId);
        }
    }

    public void deleteWishlistById( Integer wishlistId) {

        wishlistRepository.deleteById(wishlistId);
    }



    public Wishlist transferToWishlist(WishlistDto Dto) {

        var wishlist = new Wishlist();

        wishlist.setWishlistId(Dto.getWishlistId());
        wishlist.setWishlistName(Dto.getWishlistName());
        return wishlist;
    }

}
