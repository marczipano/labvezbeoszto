package com.demonstrait;


import com.demonstrait.controller.ApplicationController;
import com.demonstrait.controller.CandidateController;
import com.demonstrait.controller.CourseController;
import com.demonstrait.model.Application;
import com.demonstrait.model.Candidate;
import com.demonstrait.model.Course;
import com.demonstrait.service.ApplicationService;
import com.demonstrait.service.CandidateService;
import com.demonstrait.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class Algo implements CommandLineRunner {

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    ApplicationService applicationService;
    CourseService courseService;
    CandidateService candidateService;

    public Algo(){}

    @Override
    public void run(String... args) throws Exception {
        Algo algo = applicationContextProvider.getApplicationContext().getBean(Algo.class);

        applicationService = applicationContextProvider.getApplicationContext().getBean(ApplicationService.class);
        candidateService = applicationContextProvider.getApplicationContext().getBean(CandidateService.class);
        courseService = applicationContextProvider.getApplicationContext().getBean(CourseService.class);

    }

    public void generateTutor(){
        ArrayList<Application> applications = (ArrayList<Application>)applicationService.getApplications();
        ArrayList<Candidate> candidates = (ArrayList<Candidate>)candidateService.getCandidates();
        ArrayList<Course> courses = (ArrayList<Course>)courseService.getCourses();


        //hány jelentkező, ezt kell megszámolni
        Integer[] coursesApplicants = new Integer[courses.size()];

        //melyik coursera melyik ember
        // //HashMap<Integer, Integer[]>

        for(int i = 0; i < courses.size(); i++){
            coursesApplicants[i] = 0;
        }

        for(int i = 0; i < applications.size(); i++){
            for(int j = 0; j < courses.size(); j++){
                if(applications.get(i).getCourseId() == courses.get(j).getId())
                    coursesApplicants[j] ++;
            }
        }

        for(int j = 0; j < courses.size(); j++){

            int id;
            int min = 0;
            for(int i = 0; i < courses.size(); i++){
                if(coursesApplicants[i] < min) {
                    coursesApplicants[i] = min;
                }
            }



        }
    }
}
