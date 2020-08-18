package owt.demo.contactsapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import owt.demo.contactsapi.model.Contact;
import owt.demo.contactsapi.model.Skill;
import owt.demo.contactsapi.model.SkilledContact;
import owt.demo.contactsapi.model.SkilledContactKey;
import owt.demo.contactsapi.repository.ContactRepository;
import owt.demo.contactsapi.repository.SkillRepository;
import owt.demo.contactsapi.repository.SkilledContactRepository;

import java.util.List;

@SpringBootApplication
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
            Contact contact = Contact.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .contactId(1L).build();

            Contact contact2 = Contact.builder()
                    .firstName("Moris")
                    .lastName("Johnson")
                    .contactId(1L).build();

            Skill skill = new Skill("Programming");

            contactRepository.save(contact);
            skillRepository.save(skill);

            SkilledContactKey skilledContactKey = new SkilledContactKey();
            skilledContactKey.setContactId(1L);
            skilledContactKey.setSkillId("Programming");
            SkilledContact skilledContact = new SkilledContact(skilledContactKey,
                    contact, skill, "Advanced");
            skilledContactRepository.save(skilledContact);

            List<SkilledContact> skilledContacts = skilledContactRepository.findAll();
            SkilledContact skilledContact1 = skilledContactRepository.findById(skilledContactKey).orElse(null);
            logger.info("SkilledContacts found {}", skilledContact1);

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
