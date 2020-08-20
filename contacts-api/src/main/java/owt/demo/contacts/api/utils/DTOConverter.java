package owt.demo.contacts.api.utils;

import owt.demo.contacts.model.*;

public class DTOConverter {
    public static Contact contactEntityToDTO(ContactEntity entity) {
        return new Contact()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .fullName(entity.getFullName())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber());
    }

    public static ContactEntity contactDTOToEntity(Contact contact) {
        return ContactEntity.builder()
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .fullName(contact.getFullName())
                .address(contact.getAddress())
                .email(contact.getEmail())
                .phoneNumber(contact.getPhoneNumber())
                .build();
    }

    public static Skill skillEntityToDTO(SkillEntity entity) {
        return new Skill()
                .skill(entity.getSkill());
    }

    public static SkillEntity skillDTOToEntity(Skill skill) {
        return new SkillEntity(skill.getSkill());
    }

    public static User userEntityToDTO(UserEntity userEntity) {
        return new User().id(userEntity.getId())
                .password(userEntity.getPassword())
                .username(userEntity.getUsername());
    }

    public static UserEntity userDTOToEntity(User user) {
        return UserEntity.builder().id(user.getId())
                .password(user.getPassword())
                .username(user.getUsername()).build();
    }

    // TODO: SkilledContact DTO to contain only references to Contact and Skill and level in spec
}
