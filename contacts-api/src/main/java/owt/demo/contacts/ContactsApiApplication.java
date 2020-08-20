package owt.demo.contacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import owt.demo.contacts.model.*;
import owt.demo.contacts.repository.ContactRepository;
import owt.demo.contacts.repository.SkillRepository;
import owt.demo.contacts.repository.SkilledContactRepository;
import owt.demo.contacts.repository.UserRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@ComponentScan(basePackages = {"owt.demo.contacts", "owt.demo.contacts.api"})
@EnableSwagger2
public class ContactsApiApplication implements CommandLineRunner {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    SkilledContactRepository skilledContactRepository;
    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(ContactsApiApplication.class);

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ContactsApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            UserEntity admin = UserEntity.builder()
                    .id(0L)
                    .username("admin")
                    .password("password").build();
            UserEntity userEntity1 = UserEntity.builder()
                    .username("user1")
                    .password("password1")
                    .id(1L).build();

            userRepository.save(admin);
            userRepository.save(userEntity1);

            ContactEntity john = ContactEntity.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .contactId(1L).build();

            ContactEntity morris = ContactEntity.builder()
                    .firstName("Moris")
                    .lastName("Johnson")
                    .contactId(2L).build();

            SkillEntity programmingSkill = new SkillEntity("Programming");
            SkillEntity knittingSkill = new SkillEntity("Knitting");

            contactRepository.save(john);
            contactRepository.save(morris);
            skillRepository.save(programmingSkill);
            skillRepository.save(knittingSkill);

            // Very tedious to create a skilledContact.
            SkilledContactKey skilledContactKey = new SkilledContactKey();
            skilledContactKey.setContactId(1L);
            skilledContactKey.setSkillId("Programming");
            SkilledContactEntity skilledContactEntity = new SkilledContactEntity(skilledContactKey,
                    john, programmingSkill, "Advanced");
            skilledContactRepository.save(skilledContactEntity);

            SkilledContactKey skilledContactKey2 = new SkilledContactKey();
            skilledContactKey2.setContactId(1L);
            skilledContactKey2.setSkillId("Knitting");
            SkilledContactEntity skilledContactEntity2 = new SkilledContactEntity(skilledContactKey2,
                    john, knittingSkill, "Basic");
            skilledContactRepository.save(skilledContactEntity2);

            SkilledContactKey skilledContactKey3 = new SkilledContactKey();
            skilledContactKey3.setContactId(2L);
            skilledContactKey3.setSkillId("Knitting");
            SkilledContactEntity skilledContactEntity3 = new SkilledContactEntity(skilledContactKey3,
                    morris, knittingSkill, "Expert");
            skilledContactRepository.save(skilledContactEntity3);

            List<SkilledContactEntity> skilledContactEntities = skilledContactRepository
                    .findSkilledContactEntitiesByContactEntity_ContactId(1L);
            /*List<SkillEntity> skills = new ArrayList<>();
            for (SkilledContactEntity s: skilledContactEntities) {
                skills.add(s.getSkillEntity());
            }*/
            logger.info("Skills found {} for contact 1", skilledContactEntities.stream()
                    .map(SkilledContactEntity::getSkillEntity).collect(Collectors.toList()));

            /*List<SkilledContactEntity> skilledContactEntities = skilledContactRepository.findAll();
            SkilledContactEntity skilledContactEntity1 = skilledContactRepository.findById(skilledContactKey).orElse(null);
            logger.info("SkilledContacts found {}", skilledContactEntity1);*/

        };
    }

    static class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
