package nl.novi.loahy.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ShoppingCartProductKey implements Serializable {

    @Column(name = "shopping_cart_id")
    private Integer shoppingCartId;

    @Column(name = "product_id")
    private Integer productId;

    public ShoppingCartProductKey() {
    }

    public ShoppingCartProductKey(Integer shoppingCartId, Integer productId) {
        this.shoppingCartId = shoppingCartId;
        this.productId = productId;
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ShoppingCartProductKey that = (ShoppingCartProductKey) o;
        return shoppingCartId.equals(that.shoppingCartId)&& productId.equals(that.productId);
    }

    @Override
    public int hashCode() {return Objects.hash(shoppingCartId, productId);}
}
