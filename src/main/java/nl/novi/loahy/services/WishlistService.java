package nl.novi.loahy.services;

import nl.novi.loahy.dtos.WishlistDto;
import nl.novi.loahy.exceptions.WishlistNotFoundException;
import nl.novi.loahy.models.Wishlist;
import nl.novi.loahy.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {
    
    private final WishlistRepository wishlistRepository;


    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<WishlistDto> getAllWishlists() {
        List<WishlistDto> collection = new ArrayList<>();
        List<Wishlist> list = wishlistRepository.findAll();
        for (Wishlist wishlist : list) {
            collection.add(transferToDto(wishlist));
        }
        return collection;
    }


    public WishlistDto addWishlist(WishlistDto wishlistDto) {
        Wishlist wl =  transferToWishlist(wishlistDto);
        wishlistRepository.save(wl);
        return wishlistDto;
    }

    public WishlistDto updateWishlist(Integer wishlistId, WishlistDto wishlistDto) {
        if (wishlistRepository.findById(wishlistId).isPresent()) {

            Wishlist wishlist = wishlistRepository.findById(wishlistId).get();

            Wishlist wishlist1 = transferToWishlist(wishlistDto);
            wishlist1.setWishlistId(wishlist.getWishlistId());

            wishlistRepository.save(wishlist1);

            return transferToDto(wishlist1);
        } else {
            throw new WishlistNotFoundException(wishlistId);
        }
    }

    public void deleteWishlistById( Integer wishlistId) {

        wishlistRepository.deleteById(wishlistId);
    }


    public WishlistDto transferToDto(Wishlist wishlist) {
        
        var wishlistDto = new WishlistDto();
        
        wishlistDto.wishlistId = wishlist.getWishlistId();
        
        return wishlistDto;
    }

    public Wishlist transferToWishlist(WishlistDto wishlistDto) {

        var wishlist = new Wishlist();

        wishlist.setWishlistId(wishlistDto.getWishlistId());
        return wishlist;
    }

}
