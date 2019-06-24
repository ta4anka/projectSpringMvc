package tk.ta4anka.employeemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.ta4anka.employeemanager.model.Employee;

public interface DepartmentDAO extends JpaRepository<Employee,Integer> {
}
