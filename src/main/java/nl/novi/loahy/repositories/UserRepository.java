package nl.novi.loahy.repositories;

import nl.novi.loahy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByUserEmailIs(String userEmail);

}
