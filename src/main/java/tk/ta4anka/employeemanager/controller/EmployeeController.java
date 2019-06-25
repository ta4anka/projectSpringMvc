package tk.ta4anka.employeemanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.ta4anka.employeemanager.model.Employee;
import tk.ta4anka.employeemanager.service.impl.EmployeeServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/list")
    public String listEmployee(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        model.addAttribute("employee", new Employee());
        return "employee_form";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/showFormForUpdate/{employeeId}")
    public String showFormForUpdate(@PathVariable("employeeId") int id, Model model){
        model.addAttribute("employee",employeeService.getById(id));
        return "employee_form";
    }

    @GetMapping("/delete/{employeeId}")
    public String deleteCustomer(@PathVariable("employeeId") int id){

        employeeService.deleteById(id);

        return "redirect:/employee/list";
    }

}
