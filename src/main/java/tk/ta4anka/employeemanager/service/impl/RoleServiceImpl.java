package tk.ta4anka.employeemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ta4anka.employeemanager.model.Role;
import tk.ta4anka.employeemanager.repository.RoleRepository;
import tk.ta4anka.employeemanager.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {

    }
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.getOne(id);
    }
}
