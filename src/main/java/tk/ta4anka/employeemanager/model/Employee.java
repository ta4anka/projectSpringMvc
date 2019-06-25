package tk.ta4anka.employeemanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private int salary;



    @Column(name="birth_day")
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(name="employment_day")
    @Temporal(TemporalType.DATE)
    private  Date employmentDay;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

}