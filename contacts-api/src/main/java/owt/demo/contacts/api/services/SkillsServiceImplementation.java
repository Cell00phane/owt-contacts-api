package owt.demo.contacts.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owt.demo.contacts.api.utils.DTOConverter;
import owt.demo.contacts.model.Skill;
import owt.demo.contacts.model.SkillEntity;
import owt.demo.contacts.repository.SkillRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillsServiceImplementation implements SkillsService {

    @Autowired
    SkillRepository skillRepository;


    @Override
    public List<Skill> getSkills() {
        List<Skill> skills = new ArrayList<>();

        for (SkillEntity skillEntity: skillRepository.findAll()) {
            skills.add(DTOConverter.SkillEntityToDTO(skillEntity));
        }
        return skills;
    }
}
