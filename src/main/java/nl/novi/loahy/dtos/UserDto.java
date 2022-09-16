package nl.novi.loahy.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import nl.novi.loahy.models.Authority;

import java.util.Set;


public class UserDto {

    public String userEmail;
    public String userPassword;
    public String userName;
    public String userAdres;
    public Long userPhone;

    public WishlistDto wishlistDto;

    public ShoppingCartDto shoppingCartDto;

    @JsonDeserialize
    public Set<Authority> authorities;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAdres() {
        return userAdres;
    }

    public void setUserAdres(String userAdres) {
        this.userAdres = userAdres;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public WishlistDto getWishlistDto() {
        return wishlistDto;
    }

    public void setWishlistDto(WishlistDto wishlistDto) {
        this.wishlistDto = wishlistDto;
    }

    public ShoppingCartDto getShoppingCartDto() {
        return shoppingCartDto;
    }

    public void setShoppingCartDto(ShoppingCartDto shoppingCartDto) {
        this.shoppingCartDto = shoppingCartDto;
    }
}
