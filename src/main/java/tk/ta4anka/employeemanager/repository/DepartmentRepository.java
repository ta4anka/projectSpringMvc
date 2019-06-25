package tk.ta4anka.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.ta4anka.employeemanager.model.Department;


public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
