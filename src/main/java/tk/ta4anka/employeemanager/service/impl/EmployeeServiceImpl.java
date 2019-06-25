package tk.ta4anka.employeemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.ta4anka.employeemanager.repository.EmployeeRepository;
import tk.ta4anka.employeemanager.model.Employee;
import tk.ta4anka.employeemanager.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.getOne(id);
    }
}
