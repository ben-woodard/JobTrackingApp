package com.jobtrackingapp.jobtrackingapp.web;

import com.jobtrackingapp.jobtrackingapp.domain.User;
import com.jobtrackingapp.jobtrackingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.put("user", new User());
        return "login";
    }

    @PostMapping("/register")
    public String postRegister(ModelMap model, User newUser) {
        userService.saveUser(newUser);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHome(ModelMap model, User existingUser){
//        return userService.findById(existingUser);
        return "home";
    }
}
