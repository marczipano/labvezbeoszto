package com.demonstrait.service;


import com.demonstrait.model.Course;
import com.demonstrait.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CourseService {

    private static CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }


    public Course findCourseById(@PathVariable Integer id) {
        return courseRepository.findCourseById(id);
    }

    public List<Course> findAllByName(@PathVariable String name) {
        return courseRepository.findAllByName(name);
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }

    public static void deleteCourse(Integer id){  courseRepository.deleteCourseById(id);   }

    public static void deleteCourseByCandidate(Integer id){  courseRepository.deleteCourseByCandidate(id);   }



}
