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
import owt.demo.contacts.model.ContactEntity;
import owt.demo.contacts.model.SkillEntity;
import owt.demo.contacts.model.SkilledContactEntity;
import owt.demo.contacts.model.SkilledContactKey;
import owt.demo.contacts.repository.ContactRepository;
import owt.demo.contacts.repository.SkillRepository;
import owt.demo.contacts.repository.SkilledContactRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

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
            ContactEntity contactEntity = ContactEntity.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .contactId(1L).build();

            ContactEntity contactEntity2 = ContactEntity.builder()
                    .firstName("Moris")
                    .lastName("Johnson")
                    .contactId(1L).build();

            SkillEntity skillEntity = new SkillEntity("Programming");

            contactRepository.save(contactEntity);
            skillRepository.save(skillEntity);

            /*SkilledContactKey skilledContactKey = new SkilledContactKey();
            skilledContactKey.setContactId(1L);
            skilledContactKey.setSkillId("Programming");
            SkilledContactEntity skilledContactEntity = new SkilledContactEntity(skilledContactKey,
                    contactEntity, skillEntity, "Advanced");
            skilledContactRepository.save(skilledContactEntity);

            List<SkilledContactEntity> skilledContactEntities = skilledContactRepository.findAll();
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
