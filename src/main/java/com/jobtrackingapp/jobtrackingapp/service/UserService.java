package com.jobtrackingapp.jobtrackingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ApplicationService appService;

    @Autowired
    public UserService(ApplicationService appService) {
        this.appService = appService;
    }
}
