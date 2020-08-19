package owt.demo.contacts.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactEntityTest {
    private ContactEntity contactEntity;

    @BeforeEach
    void setupTestUser() {
        contactEntity = new ContactEntity().toBuilder()
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
        assertEquals("John", contactEntity.getFirstName());
    }

    @Test
    void getLastname() {
        assertEquals("Doe", contactEntity.getLastName());
    }

    @Test
    void getFullname() {
        assertEquals("John D. Doe", contactEntity.getFullName());
    }

    @Test
    void getEmail() {
        assertEquals("John@Doe.com", contactEntity.getEmail());
    }
}