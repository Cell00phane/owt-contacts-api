package owt.demo.contacts.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * A ContactEntity entity. Each contactEntity has a auto-generated id in the database.
 */
@Entity
@Table(name = "contact")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;

    // The user id that owns this contactEntity
    private Long ownerId;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String fullName;
    private String address;
    private String email;
    private String phoneNumber;
}
