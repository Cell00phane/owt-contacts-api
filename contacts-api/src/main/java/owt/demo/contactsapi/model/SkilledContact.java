package owt.demo.contactsapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SkilledContact {

    @EmbeddedId
    SkilledContactKey id;

    @ManyToOne
    @MapsId("contact_id")
    @JoinColumn(name = "contact_id")
    Contact contact;

    @ManyToOne
    @MapsId("skill")
    @JoinColumn(name = "skill")
    Skill skill;

    String level;
}
