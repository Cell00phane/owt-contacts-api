package owt.demo.contacts.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A skillEntity is identified by its name.
 */
@Entity
@Table(name = "skill")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SkillEntity {
    @Id
    private String skill;
}
