package com.jobtrackingapp.jobtrackingapp.web;

import com.jobtrackingapp.jobtrackingapp.domain.Application;
import com.jobtrackingapp.jobtrackingapp.domain.User;
import com.jobtrackingapp.jobtrackingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        Long userId = newUser.getUserId();
        System.out.println(userId);
        return "redirect:/home/" + newUser.getUserId();
    }

    @GetMapping("/home/{userId}")
    public String getHome(ModelMap model, @PathVariable Long userId) {
        User savedUser = userService.findById(userId);
        List<Application> applications = savedUser.getApplications();
        if (savedUser == null) {
            return "redirect:/register";
        }
        model.put("applications", applications);
        model.put("user", savedUser);
        return "home";
    }
}
