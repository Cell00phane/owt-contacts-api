package owt.demo.contacts.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class SkilledContactKey implements Serializable {
    @Column(name = "contact_id")
    Long contactId;

    @Column(name = "skillEntity")
    String skillId;
}
