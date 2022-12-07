package nl.novi.loahy.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import nl.novi.loahy.models.Authority;

import java.util.Set;


public class UserDto {

    public String userEmail;
    public String password;

//    public String userFirstName;
//    public String userLastName;
//    public String userStreetName;
//    public String userHouseNumber;
//    public String userHouseNumberAddition;
//    public String userCity;
//    public String userZipcode;
//    public Long userPhone;


    public WishlistDto wishlistDto;

    public ShoppingCartDto shoppingCartDto;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


//    public String getUserFirstName() {
//        return userFirstName;
//    }
//
//    public void setUserFirstName(String userFirstName) {
//        this.userFirstName = userFirstName;
//    }
//
//    public String getUserLastName() {
//        return userLastName;
//    }
//
//    public void setUserLastName(String userLastName) {
//        this.userLastName = userLastName;
//    }
//
//    public String getUserStreetName() {
//        return userStreetName;
//    }
//
//    public void setUserStreetName(String userStreetName) {
//        this.userStreetName = userStreetName;
//    }
//
//    public String getUserHouseNumber() {
//        return userHouseNumber;
//    }
//
//    public void setUserHouseNumber(String userHouseNumber) {
//        this.userHouseNumber = userHouseNumber;
//    }
//
//    public String getUserHouseNumberAddition() {
//        return userHouseNumberAddition;
//    }
//
//    public void setUserHouseNumberAddition(String userHouseNumberAddition) {
//        this.userHouseNumberAddition = userHouseNumberAddition;
//    }
//
//    public String getUserCity() {
//        return userCity;
//    }
//
//    public void setUserCity(String userCity) {
//        this.userCity = userCity;
//    }
//
//    public String getUserZipcode() {
//        return userZipcode;
//    }
//
//    public void setUserZipcode(String userZipcode) {
//        this.userZipcode = userZipcode;
//    }
//
//    public Long getUserPhone() {
//        return userPhone;
//    }
//
//    public void setUserPhone(Long userPhone) {
//        this.userPhone = userPhone;
//    }

}
