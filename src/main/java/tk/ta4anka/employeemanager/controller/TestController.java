package tk.ta4anka.employeemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("message", "Hello Spring MVC 5!");
        return "index";
    }
}


