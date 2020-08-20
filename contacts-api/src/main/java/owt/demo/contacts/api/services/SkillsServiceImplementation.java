package owt.demo.contacts.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import owt.demo.contacts.api.exceptions.NotFoundException;
import owt.demo.contacts.api.utils.DTOConverter;
import owt.demo.contacts.model.Skill;
import owt.demo.contacts.model.SkillEntity;
import owt.demo.contacts.repository.SkillRepository;

import java.net.URI;
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
            skills.add(DTOConverter.skillEntityToDTO(skillEntity));
        }
        return skills;
    }

    @Override
    public Skill getSkillById(String id) throws NotFoundException {
        SkillEntity skillEntity = skillRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No skill found with the name " + id));

        return DTOConverter.skillEntityToDTO(skillEntity);
    }

    @Override
    public URI saveSkill(Skill skill) {
        SkillEntity skillEntity = DTOConverter.skillDTOToEntity(skill);
        skillRepository.save(skillEntity);

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(skillEntity.getSkill()).toUri();
    }
}
