package com.demonstrait.repo;

import com.demonstrait.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);

    List<Course> findAllByName(String name);

    void deleteCourseById(Integer id);

    @Transactional
    @Modifying
    @Query( "DELETE FROM Application WHERE candidate_id = :cid" )
    void deleteCourseByCandidate(@Param("cid") Integer id);

}
