package tk.ta4anka.employeemanager.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    @Pattern(regexp="^[A-Z]+[a-zA-Z]*$" , message="Only the letters, first is lower case")
    private String firstName;

    @Column(name="last_name")
    @Pattern(regexp="^[A-Z]+[a-zA-Z]*$" , message="Only the letters, first is lower case")
    private String lastName;

    @Min(value=1000, message = "Must be greater than or equal to 1000")
    private int salary;


    @Column(name="birth_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(name="employment_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private  Date employmentDay;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

}