package owt.demo.contacts.api.services;

import owt.demo.contacts.api.exceptions.NotFoundException;
import owt.demo.contacts.model.Skill;

import java.net.URI;
import java.util.List;

public interface SkillsService {
    List<Skill> getSkills();

    Skill getSkillById(String id) throws NotFoundException;

    URI saveSkill(Skill skill);
}
