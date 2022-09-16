package nl.novi.loahy.repository;

import nl.novi.loahy.models.ShoppingCartProduct;
import nl.novi.loahy.models.ShoppingCartProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, ShoppingCartProductKey> {
    Collection<ShoppingCartProduct> findAllByProduct_ProductId(Integer productId);

    Collection<ShoppingCartProduct> findAllByShoppingCart_ShoppingCartId(Integer shoppingCartId);
}
