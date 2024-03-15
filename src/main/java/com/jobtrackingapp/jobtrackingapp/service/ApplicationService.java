package com.jobtrackingapp.jobtrackingapp.service;

import com.jobtrackingapp.jobtrackingapp.domain.Application;
import com.jobtrackingapp.jobtrackingapp.domain.User;
import com.jobtrackingapp.jobtrackingapp.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepo;
    private final UserService userService;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepo, UserService userService) {
        this.applicationRepo = applicationRepo;
        this.userService = userService;
    }

    public Application save(Application application, Long userId) {
        User user = userService.findById(userId);
        application.setUser(user);
        user.getApplications().add(application);
        return applicationRepo.save(application);
    }
}
