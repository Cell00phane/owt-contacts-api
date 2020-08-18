package owt.demo.contactsapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import owt.demo.contactsapi.model.Skill;

@RepositoryRestResource(collectionResourceRel = "skills", path = "skills")
public interface SkillRepository extends PagingAndSortingRepository<Skill, Long> {

}