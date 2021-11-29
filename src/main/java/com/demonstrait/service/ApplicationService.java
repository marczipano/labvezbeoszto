package com.demonstrait.service;


import com.demonstrait.model.Application;
import com.demonstrait.repo.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ApplicationService {

    private static ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    public Application findApplicationById(@PathVariable Integer id) {
        return applicationRepository.findApplicationById(id);
    }

    public Application addApplication(Application application){
        return applicationRepository.save(application);
    }

    public Application updateApplication(Application application){
        return applicationRepository.save(application);
    }

    public static void deleteApplication(Integer id){  applicationRepository.deleteApplicationById(id);   }
}
