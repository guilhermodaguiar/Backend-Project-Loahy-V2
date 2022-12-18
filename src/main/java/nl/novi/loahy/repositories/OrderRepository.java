package nl.novi.loahy.repositories;

import nl.novi.loahy.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order> findById(Integer id);
}
