package nl.novi.loahy.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.loahy.models.Authority;
import nl.novi.loahy.models.Customer;
import nl.novi.loahy.models.User;

import java.util.List;
import java.util.Set;


public class UserDto {

    public String userEmail;
    public String password;

    @JsonSerialize
    public Customer customer;
    public WishlistDto wishlistDto;
    public ShoppingCartDto shoppingCartDto;
    @JsonDeserialize
    public Set<Authority> authorities;

    public static UserDto fromUser(User user){

        var userDto = new UserDto();

        userDto.userEmail = user.getUserEmail();
        userDto.password = user.getUserPassword();
        userDto.authorities = user.getAuthorities();
        userDto.customer = (user.getCustomer());

        return userDto;
    }


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
