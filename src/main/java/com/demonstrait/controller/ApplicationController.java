package com.demonstrait.controller;


import com.demonstrait.model.Application;
import com.demonstrait.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications(){
        List<Application> applications = applicationService.getApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationByID(@PathVariable("id") Integer id){
        Application application = applicationService.findApplicationById(id);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Application> addApplication(@Validated @RequestBody Application application) {
        Application newapplication = applicationService.addApplication(application);
        return new ResponseEntity<>(newapplication, HttpStatus.CREATED);
    }



    @PutMapping
    public ResponseEntity<Application> updateApplication(@RequestBody Application application){
        Application newApplication = applicationService.updateApplication(application);
        return new ResponseEntity<>(newApplication, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping (path ="/{id}")
    public ResponseEntity<Application> deleteApplication(@PathVariable("id") Integer id){
        applicationService.deleteApplication(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
