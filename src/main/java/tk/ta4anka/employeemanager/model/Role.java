package tk.ta4anka.employeemanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
