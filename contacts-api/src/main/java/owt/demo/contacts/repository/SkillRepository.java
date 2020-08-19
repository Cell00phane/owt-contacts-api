package owt.demo.contacts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import owt.demo.contacts.model.SkillEntity;

public interface SkillRepository extends PagingAndSortingRepository<SkillEntity, String> {

}