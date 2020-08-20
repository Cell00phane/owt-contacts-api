package owt.demo.contacts.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import owt.demo.contacts.api.exceptions.NotFoundException;
import owt.demo.contacts.api.utils.DTOConverter;
import owt.demo.contacts.model.*;
import owt.demo.contacts.repository.ContactRepository;
import owt.demo.contacts.repository.SkillRepository;
import owt.demo.contacts.repository.SkilledContactRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactsServiceImplementation implements ContactsService{

    Logger logger = LoggerFactory.getLogger(ContactsServiceImplementation.class);

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    SkilledContactRepository skilledContactRepository;
    @Autowired
    SkillRepository skillRepository;


    @Override
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();

        for (ContactEntity contactEntity: contactRepository.findAll()) {
            contacts.add(DTOConverter.contactEntityToDTO(contactEntity));
        }

        return contacts;
    }

    @Override
    public Contact getContactById(Long id) throws NotFoundException {
        ContactEntity contactEntity = contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No contact found with id "+ id));

        logger.info("Contact found");

        return DTOConverter.contactEntityToDTO(contactEntity);
    }

    @Override
    public URI saveContact(Contact contact) {
        ContactEntity contactEntity = DTOConverter.contactDTOToEntity(contact);
        contactRepository.save(contactEntity);

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(contactEntity.getContactId()).toUri();
    }

    @Override
    public List<SkillLevel> getSkillsById(Long contactId) throws NotFoundException {
        // Check that contact exists
        getContactById(contactId);
        List<SkillLevel> skillLevels = new ArrayList<>();

        List<SkilledContactEntity> skilled =
                skilledContactRepository.findSkilledContactEntitiesByContactEntity_ContactId(contactId);

        for (SkilledContactEntity s: skilled) {
            skillLevels.add(new SkillLevel()
                    .skill(s.getSkillEntity().getSkill())
                    .level(s.getLevel()));
        }
        return skillLevels;
    }

    @Override
    public SkilledContact addSkillToContact(Long contactId, SkillLevel skill) throws NotFoundException {
        String skillName = skill.getSkill();
        // Check that contact exists
        ContactEntity contactEntity = contactRepository.findById(contactId)
                .orElseThrow(() -> new NotFoundException("No contact found with id "+ contactId));

        // Check that the skill exists
        SkillEntity skillEntity = skillRepository.findById(skill.getSkill())
                .orElseThrow(() -> new NotFoundException("No skill found with the name " + skillName));

        SkilledContactKey skilledContactKey = new SkilledContactKey();
        skilledContactKey.setContactId(contactId);
        skilledContactKey.setSkillId(skillName);

        SkilledContactEntity skilledContactEntity = new SkilledContactEntity(
                skilledContactKey, contactEntity, skillEntity, skill.getLevel()
        );

        skilledContactRepository.save(skilledContactEntity);

        return new SkilledContact().contactId(contactId)
                .skill(skillName)
                .level(skill.getLevel());
    }
}
