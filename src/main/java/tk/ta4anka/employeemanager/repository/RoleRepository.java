package tk.ta4anka.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.ta4anka.employeemanager.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
