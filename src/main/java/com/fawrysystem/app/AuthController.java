package com.fawrysystem.app;

import com.fawrysystem.app.User.UserModel;
import com.fawrysystem.app.User.UserServices;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/save")
    public String registration( @ModelAttribute("user") UserModel user,
                               BindingResult result,
                               Model model){
        UserModel existing = UserServices.getInstance().getUserWithEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        UserServices.getInstance().getUsers().add(user);
        return "redirect:/register?success";
    }

}
