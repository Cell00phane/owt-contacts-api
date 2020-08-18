package owt.demo.contactsapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    void setupTestUser() {
        user = new User().toBuilder()
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
        assertEquals("John", user.getFirstName());
    }

    @Test
    void getLastname() {
        assertEquals("Doe", user.getLastName());
    }

    @Test
    void getFullname() {
        assertEquals("John D. Doe", user.getFullName());
    }

    @Test
    void getEmail() {
        assertEquals("John@Doe.com", user.getEmail());
    }
}