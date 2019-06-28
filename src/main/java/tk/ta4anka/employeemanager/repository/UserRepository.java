package tk.ta4anka.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.ta4anka.employeemanager.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
