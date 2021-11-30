package com.demonstrait.controller;


import com.demonstrait.model.Course;
import com.demonstrait.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){ this.courseService = courseService; }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseService.getCourses();
        return  new ResponseEntity<>(courses, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseByID(@PathVariable("id") Integer id){
        Course course = courseService.findCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Course>> getCourseByName(@RequestParam(value="name") String name){
        List<Course> course = courseService.findAllByName(name);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Course> addCourse(@Validated @RequestBody Course course) {
        Course newcourse = courseService.addCourse(course);
        return new ResponseEntity<>(newcourse, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        Course _course = courseService.updateCourse(course);
        return new ResponseEntity<>(_course, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping (path ="/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable("id") Integer id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
