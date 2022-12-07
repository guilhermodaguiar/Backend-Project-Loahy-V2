package nl.novi.loahy.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false, length = 255)
    private String password;

//    @Column(name = "user_first_name")
//    String userFirstName;
//
//    @Column(name = "user_last_name")
//    String userLastName;
//
//    @Column(name = "user_street_name")
//    String userStreetName;
//
//    @Column(name = "user_house_number")
//    String userHouseNumber;
//
//    @Column(name = "user_house_number_addition")
//    String userHouseNumberAddition;
//
//    @Column(name = "user_city")
//    String userCity;
//
//    @Column(name = "user_zipcode")
//    String userZipcode;
//
//    @Column(name = "user_phone")
//    Long userPhone;


    @OneToOne
    Customer customer;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "userEmail",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    @OneToOne
    Wishlist wishlist;

    @OneToOne
    ShoppingCart shoppingCart;


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }


    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

