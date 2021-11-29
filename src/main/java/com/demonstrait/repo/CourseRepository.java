package com.demonstrait.repo;

import com.demonstrait.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);

    List<Course> findAllByName(String name);

    void deleteCourseById(Integer id);

}
