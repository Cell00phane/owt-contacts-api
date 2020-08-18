package owt.demo.contactsapi.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * A Contact entity. Each contact has a auto-generated id in the database.
 */
@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;

    // The user id that owns this contact
    private Long ownerId;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String fullName;
    private String address;
    private String email;
    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "skilled_contact",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "skill"))
    Set<Skill> skills;
}
