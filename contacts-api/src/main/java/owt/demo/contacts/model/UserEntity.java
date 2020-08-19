package owt.demo.contacts.model;

import lombok.*;

import javax.persistence.*;

/**
 * A UserEntity entity. Each user has a auto-generated id in the database.
 */
@Entity
@Table(name = "user")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
}
