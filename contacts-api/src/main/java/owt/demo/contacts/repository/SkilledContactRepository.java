package owt.demo.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owt.demo.contacts.model.*;

import java.util.List;

public interface SkilledContactRepository extends JpaRepository<SkilledContactEntity, SkilledContactKey> {
    List<SkilledContactEntity> findSkilledContactEntitiesByContactEntity_ContactId(Long contactId);
}
