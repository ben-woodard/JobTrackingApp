package com.jobtrackingapp.jobtrackingapp.web;

import com.jobtrackingapp.jobtrackingapp.domain.Application;
import com.jobtrackingapp.jobtrackingapp.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/createApplication/{userId}")
    public String createApplication(ModelMap model) {
        model.put("application", new Application());
        return "create-application";
    }

    @PostMapping("/createApplication/{userId}")
    public String createApplication(@PathVariable Long userId, Application application) {
//        System.out.println(application.getAppDate());
        applicationService.save(application, userId);

        return "redirect:/home/" + userId;
    }
}
