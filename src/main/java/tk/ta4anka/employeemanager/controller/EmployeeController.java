package tk.ta4anka.employeemanager.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import tk.ta4anka.employeemanager.helper.DepartmentPropertyEditor;
import tk.ta4anka.employeemanager.model.Department;
import tk.ta4anka.employeemanager.model.Employee;
import tk.ta4anka.employeemanager.service.DepartmentService;
import tk.ta4anka.employeemanager.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        DepartmentPropertyEditor departmentPropertyEditor = new DepartmentPropertyEditor(departmentService);
        webDataBinder.registerCustomEditor(Department.class,departmentPropertyEditor);
    }

    @GetMapping("/list")
    public String listEmployee(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.findAll());
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
        model.addAttribute("departments", departmentService.findAll());
        return "employee_form";
    }

    @GetMapping("/delete/{employeeId}")
    public String deleteCustomer(@PathVariable("employeeId") int id){

        employeeService.deleteById(id);

        return "redirect:/employee/list";
    }
}
