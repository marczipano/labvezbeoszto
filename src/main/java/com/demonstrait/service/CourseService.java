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

    public Course addCourseWithValues(String name, String year, String tutor){
        Course course = new Course();
        course.setName(name);
        course.setYear(year);
        course.setTutor(tutor);
        course.setId((int)(Math.random()*100));

        courseRepository.save(course);
        return course;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }


    public Course findCourseById(@PathVariable Integer id) {
        return courseRepository.findCourseByID(id);
    }

    public Course addCourse(Course course){
        course.setId((int) (Math.random() * 100));
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }

    public static void deleteCourse(Integer id){

        courseRepository.deleteCourseById(id);

    }
}
