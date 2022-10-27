package nl.novi.loahy.repositories;

import nl.novi.loahy.models.AboutBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AboutBrandRepository extends JpaRepository<AboutBrand, String> {
    Optional<AboutBrand> findAboutBrandByBrandTitle (String brandTitle);
}
