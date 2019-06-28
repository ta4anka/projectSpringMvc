package tk.ta4anka.employeemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.ta4anka.employeemanager.model.Role;
import tk.ta4anka.employeemanager.model.User;
import tk.ta4anka.employeemanager.repository.RoleRepository;
import tk.ta4anka.employeemanager.repository.UserRepository;
import tk.ta4anka.employeemanager.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword((user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(3L));
        user.setRoles(roles);
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }
}
