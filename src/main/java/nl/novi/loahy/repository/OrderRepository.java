package nl.novi.loahy.repository;

import nl.novi.loahy.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
