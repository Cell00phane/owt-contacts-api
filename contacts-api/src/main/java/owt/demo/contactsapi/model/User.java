package owt.demo.contactsapi.model;

import lombok.*;

import javax.persistence.*;

/**
 * A User entity. Each user has a auto-generated id in the database.
 */
@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
}
