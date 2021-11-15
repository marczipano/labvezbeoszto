package com.demonstrait.controller;


import com.demonstrait.model.Candidate;
import com.demonstrait.model.Course;
import com.demonstrait.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){ this.courseService = courseService; }

    @GetMapping("/{candidateId}/courses")
    public ResponseEntity<List<Course>> getAllCourse(){
        List<Course> courses = courseService.getCourses();
        return  new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(path ="{candidateId}/courses/{id}")
    public ResponseEntity<Course> getCourseByID(@PathVariable("id") Integer id){
        Course course = courseService.findCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping(path ="{candidateId}/courses/{id}")
    public ResponseEntity<Course> addCandidate(@Validated @RequestBody Course course) {
        Course newcourse = courseService.addCourse(course);
        return new ResponseEntity<>(newcourse, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        Course _course = courseService.addCourse(course);
        return new ResponseEntity<>(_course, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping (path ="{id}")
    public ResponseEntity<Candidate> deleteCourse(@PathVariable("id") Integer id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
