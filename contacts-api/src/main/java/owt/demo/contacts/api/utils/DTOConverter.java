package owt.demo.contacts.api.utils;

import owt.demo.contacts.model.Contact;
import owt.demo.contacts.model.ContactEntity;
import owt.demo.contacts.model.Skill;
import owt.demo.contacts.model.SkillEntity;

public class DTOConverter {
    public static Contact ContactEntityToDTO(ContactEntity entity) {
        return new Contact()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .fullName(entity.getFullName())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber());
    }

    public static ContactEntity ContactDTOToEntity(Contact contact) {
        return ContactEntity.builder()
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .fullName(contact.getFullName())
                .address(contact.getAddress())
                .email(contact.getEmail())
                .phoneNumber(contact.getPhoneNumber())
                .build();
    }

    public static Skill SkillEntityToDTO(SkillEntity entity) {
        return new Skill()
                .skill(entity.getSkill());
    }

    public static SkillEntity SkillDTOToEntity(Skill skill) {
        return new SkillEntity(skill.getSkill());
    }
}
