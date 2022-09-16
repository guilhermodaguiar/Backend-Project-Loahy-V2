package nl.novi.loahy.models;

import javax.persistence.*;

@Entity
public class ShoppingCartProduct {

    @EmbeddedId
    private ShoppingCartProductKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("shoppingCartId")
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public ShoppingCartProductKey getId() {
        return id;
    }

    public void setId(ShoppingCartProductKey id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
