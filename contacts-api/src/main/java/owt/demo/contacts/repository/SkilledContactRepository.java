package owt.demo.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owt.demo.contacts.model.SkilledContactEntity;
import owt.demo.contacts.model.SkilledContactKey;

public interface SkilledContactRepository extends JpaRepository<SkilledContactEntity, SkilledContactKey> {


}
