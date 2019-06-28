package tk.ta4anka.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tk.ta4anka.employeemanager.model.User;

import tk.ta4anka.employeemanager.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User currentUser = userService.findByUsername(user.getUsername());

        if(currentUser !=null){
            model.addAttribute("message","This user exists!");
            return "registration";
        }
        userService.save(user);

        return "redirect:/login";

    }
}
