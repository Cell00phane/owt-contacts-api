package owt.demo.contacts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import owt.demo.contacts.model.ContactEntity;

public interface ContactRepository extends PagingAndSortingRepository<ContactEntity, Long> {


}