package tk.ta4anka.employeemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String index (){
        return "index";
    }

    @GetMapping("/main")
    public String main (){
        return "main";
    }



}
