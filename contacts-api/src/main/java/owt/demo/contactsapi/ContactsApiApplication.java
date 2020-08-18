package owt.demo.contactsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import owt.demo.contactsapi.model.Contact;
import owt.demo.contactsapi.model.Skill;
import owt.demo.contactsapi.repository.ContactRepository;
import owt.demo.contactsapi.repository.SkillRepository;

import java.util.HashSet;

@SpringBootApplication
public class ContactsApiApplication implements CommandLineRunner {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    SkillRepository skillRepository;

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
                    .contactId(1L)
                    .skills(new HashSet<>()).build();

            Contact contact2 = Contact.builder()
                    .firstName("Moris")
                    .lastName("Johnson")
                    .contactId(1L)
                    .skills(new HashSet<>()).build();

            Skill skill = new Skill("Programming", "Advanced", new HashSet<>());

            contact.getSkills().add(skill);
            skill.getSkilledPeople().add(contact);

            contactRepository.save(contact);
            //contactRepository.save(contact2);

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
