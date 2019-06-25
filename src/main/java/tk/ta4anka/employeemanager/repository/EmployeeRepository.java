package tk.ta4anka.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.ta4anka.employeemanager.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
