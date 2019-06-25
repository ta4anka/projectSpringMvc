package tk.ta4anka.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.ta4anka.employeemanager.model.Department;

import tk.ta4anka.employeemanager.service.impl.DepartmentServiceImpl;


import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping("/list")
    public String listDepartment(Model model){
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "departments";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        model.addAttribute("department", new Department());
        return "department_form";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department){
        departmentService.save(department);

        return "redirect:/department/list";
    }

    @GetMapping("/showFormForUpdate/{departmentId}")
    public String showFormForUpdate(@PathVariable("departmentId") int id, Model model){
        System.out.println(" ========>  DEBBUGING LINE =======> id for update: " + id);
        model.addAttribute("department",departmentService.getById(id));
        System.out.println();
        return "department_form";
    }

    @GetMapping("/delete/{departmentId}")
    public String deleteCustomer(@PathVariable("departmentId") int id){
        departmentService.deleteById(id);

        return "redirect:/department/list";
    }

}