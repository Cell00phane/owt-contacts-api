package owt.demo.contactsapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A skill is identified by its name.
 */
@Entity
@Data
public class Skill {
    @Id
    private String skill;
    private long level;
}
