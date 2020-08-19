package owt.demo.contacts.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "skilled_contact")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SkilledContactEntity {

    @EmbeddedId
    SkilledContactKey id;

    @ManyToOne
    @MapsId("contact_id")
    @JoinColumn(name = "contact_id")
    ContactEntity contactEntity;

    @ManyToOne
    @MapsId("skillEntity")
    @JoinColumn(name = "skillEntity")
    SkillEntity skillEntity;

    String level;
}
