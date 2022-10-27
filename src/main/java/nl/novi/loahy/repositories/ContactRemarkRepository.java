package nl.novi.loahy.repositories;

import nl.novi.loahy.models.ContactRemark;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRemarkRepository extends JpaRepository<ContactRemark, String> {
}
