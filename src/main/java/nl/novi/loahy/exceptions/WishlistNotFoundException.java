package nl.novi.loahy.exceptions;

public class WishlistNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;


    public WishlistNotFoundException(Integer wishlistId) {

        super(String.format("Wishlist '%s' does not exists", wishlistId));
    }
}
