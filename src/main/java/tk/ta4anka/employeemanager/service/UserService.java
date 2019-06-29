package tk.ta4anka.employeemanager.service;

import tk.ta4anka.employeemanager.model.User;

public interface UserService extends GenericService<User,Integer> {
    User findByUsername(String username);
}
