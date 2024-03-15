package com.jobtrackingapp.jobtrackingapp.service;

import com.jobtrackingapp.jobtrackingapp.domain.Application;
import com.jobtrackingapp.jobtrackingapp.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepo;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    public Application save(Application application) {
       return applicationRepo.save(application);
    }
}
