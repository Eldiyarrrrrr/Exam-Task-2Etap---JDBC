package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "users")
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "user_gen_id", sequenceName = "user_seq", allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(generator = "user_gen_id",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String userName;
    private String password;
    private String role;

    public User(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

}
