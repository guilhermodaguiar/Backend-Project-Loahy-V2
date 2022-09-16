package nl.novi.loahy.repository;

import nl.novi.loahy.models.WishlistProduct;
import nl.novi.loahy.models.WishlistProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface WishlistProductRepository extends JpaRepository<WishlistProduct, WishlistProductKey> {
    Collection<WishlistProduct> findAllByWishlist_WishlistId(Integer wishlistId);
    Collection<WishlistProduct> findAllByProduct_ProductId(Integer productId);
}
