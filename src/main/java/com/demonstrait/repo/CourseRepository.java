package com.demonstrait.repo;

import com.demonstrait.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseByID(Integer id);

    void deleteCourseById(Integer id);
}
