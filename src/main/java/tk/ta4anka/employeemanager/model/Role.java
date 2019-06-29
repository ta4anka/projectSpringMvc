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
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
    private Set<User> users;

}
