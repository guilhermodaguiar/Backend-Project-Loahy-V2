package nl.novi.loahy.repository;

import nl.novi.loahy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
