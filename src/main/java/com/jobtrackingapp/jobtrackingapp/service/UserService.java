package com.jobtrackingapp.jobtrackingapp.service;

import com.jobtrackingapp.jobtrackingapp.domain.User;
import com.jobtrackingapp.jobtrackingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(User newUser) {
        return userRepo.save(newUser);
    }

    public User findById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }
}
