package owt.demo.contactsapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * A skill is identified by its name.
 */
@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Skill {
    @Id
    private String skill;
    private String level;

    @ManyToMany(mappedBy = "skills")
    Set<Contact> skilledPeople;
}
