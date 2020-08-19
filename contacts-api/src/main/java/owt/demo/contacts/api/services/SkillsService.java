package owt.demo.contacts.api.services;

import org.springframework.stereotype.Service;
import owt.demo.contacts.model.Skill;

import java.util.List;

@Service
public interface SkillsService {
    List<Skill> getSkills();
}
