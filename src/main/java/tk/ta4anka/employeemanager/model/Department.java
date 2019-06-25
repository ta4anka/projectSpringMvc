package tk.ta4anka.employeemanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
    private Set<Employee> employees;
}
