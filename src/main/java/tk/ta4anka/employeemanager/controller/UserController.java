package tk.ta4anka.employeemanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import tk.ta4anka.employeemanager.helper.RolePropertyEditor;
import tk.ta4anka.employeemanager.model.Role;
import tk.ta4anka.employeemanager.model.User;
import tk.ta4anka.employeemanager.service.RoleService;
import tk.ta4anka.employeemanager.service.UserService;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        RolePropertyEditor rolePropertyEditor = new RolePropertyEditor(roleService);
        webDataBinder.registerCustomEditor(Role.class,rolePropertyEditor);
    }

    @GetMapping("/list")
    public String listUsers(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles",roleService.findAll());
        return "users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("roles",roleService.findAll());
        System.out.println("=============> DEBUGING =============> " + roleService.findAll());
        return "user_form";
    }

    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/showFormForUpdate/{userId}")
    public String showFormForUpdate(@PathVariable("userId") int id, Model model){
        model.addAttribute("user",userService.getById(id));
        model.addAttribute("roles", roleService.findAll());
        return "user_form";
    }

    @GetMapping("/delete/{userId}")
    public String deleteCustomer(@PathVariable("userId") int id){

        userService.deleteById(id);

        return "redirect:/user/list";
    }


}
