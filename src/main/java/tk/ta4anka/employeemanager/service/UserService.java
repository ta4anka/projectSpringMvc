package tk.ta4anka.employeemanager.service;

import tk.ta4anka.employeemanager.model.User;

public interface UserService extends GenericService<User,Long> {
    User findByUsername(String username);
}
