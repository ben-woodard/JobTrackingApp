package com.jobtrackingapp.jobtrackingapp.service;

import com.jobtrackingapp.jobtrackingapp.domain.User;
import com.jobtrackingapp.jobtrackingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ApplicationService appService;

    private final UserRepository userRepo;

    @Autowired
    public UserService(ApplicationService appService, UserRepository userRepo) {
        this.appService = appService;
        this.userRepo = userRepo;
    }

    public User saveUser(User newUser) {
        return userRepo.save(newUser);
    }
}
