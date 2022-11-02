package nl.novi.loahy.repositories;

import nl.novi.loahy.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
