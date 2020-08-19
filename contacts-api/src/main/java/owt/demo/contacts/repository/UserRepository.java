package owt.demo.contacts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import owt.demo.contacts.model.UserEntity;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {


}