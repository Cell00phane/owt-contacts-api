package owt.demo.contactsapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactTest {
    private Contact contact;

    @BeforeEach
    void setupTestUser() {
        contact = new Contact().toBuilder()
                .firstName("John")
                .lastName("Doe")
                .fullName("John D. Doe")
                .address("Morgan Avenue 9")
                .email("John@Doe.com")
                .phoneNumber("+41 786957")
                .build();
    }

    @Test
    void getFirstname() {
        assertEquals("John", contact.getFirstName());
    }

    @Test
    void getLastname() {
        assertEquals("Doe", contact.getLastName());
    }

    @Test
    void getFullname() {
        assertEquals("John D. Doe", contact.getFullName());
    }

    @Test
    void getEmail() {
        assertEquals("John@Doe.com", contact.getEmail());
    }
}