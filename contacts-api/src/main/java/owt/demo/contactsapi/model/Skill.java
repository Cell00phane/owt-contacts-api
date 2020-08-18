package owt.demo.contactsapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

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
}
