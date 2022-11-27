package nl.novi.loahy.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import nl.novi.loahy.models.Authority;

import java.util.Set;


public class UserDto {

    public String userEmail;
    public String password;


    public WishlistDto wishlistDto;

    public ShoppingCartDto shoppingCartDto;

    public CustomerDto customerDto;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    @JsonDeserialize
    public Set<Authority> authorities;


    public String getUserPassword() {
        return password;
    }

    public void setUserPassword(String userPassword) {
        this.password = userPassword;
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
