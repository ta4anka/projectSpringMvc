package tk.ta4anka.employeemanager.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tk.ta4anka.employeemanager.model.User;

import tk.ta4anka.employeemanager.service.RoleService;
import tk.ta4anka.employeemanager.service.UserService;




@Controller
@SessionAttributes(types = User.class)
public class RegistrationController {

    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public RegistrationController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    private static final String ACCOUNT_SID = "AC16c1e094d544ed6d723bceb88781427b";
    private static final String AUTH_TOKEN = "43be411cede1b4ce393f314265e71668";
    private static final String TWILIO_NUMBER = "+19377574659";
    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration_form";
    }

    @PostMapping("/confirmPhoneNumber")
    public String showFormForUpdate(User user, Model model) {

        User currentUser = userService.findByUsername(user.getUsername());
        if (currentUser != null) {
            model.addAttribute("message", "This user exists!");
            return "registration_form";
        } else {
            String randomPhoneCode = String.valueOf((int) (Math.random() * 9000)+1000);
            user.setPhoneCode(randomPhoneCode);

//            System.out.println("================> FOR DEBUGING - twilio imitation: =============> " + randomPhoneCode); // TODO: DELETE

            Message.creator(
                    new PhoneNumber(user.getPhoneNumber()),
                    new PhoneNumber(TWILIO_NUMBER),
                    "Your verification code is " + randomPhoneCode)
                    .create();

            return "confirm_phone";
        }
    }

    @PostMapping("/registration")
    public String addUser(User user, @RequestParam("phoneCodeFromUser") String phoneCodeFromUserInput, Model model, SessionStatus status){
        if(!phoneCodeFromUserInput.equals(user.getPhoneCode())){
            model.addAttribute("message","This code is not valid! Please registration again!");
            return "registration_form";
        }else
            user.setRole(roleService.findByName("ROLE_USER"));
        userService.save(user);
        status.setComplete();
        return "redirect:/login";
    }
}
