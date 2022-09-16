package nl.novi.loahy.repository;

import nl.novi.loahy.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}
