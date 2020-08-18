package owt.demo.contactsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import owt.demo.contactsapi.model.SkilledContact;
import owt.demo.contactsapi.model.SkilledContactKey;

@RepositoryRestResource(collectionResourceRel = "skilled", path = "skilled")
public interface SkilledContactRepository extends JpaRepository<SkilledContact, SkilledContactKey> {


}
