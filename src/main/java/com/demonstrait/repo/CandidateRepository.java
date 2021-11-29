package com.demonstrait.repo;

import com.demonstrait.model.Candidate;
import com.demonstrait.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Candidate findCandidateById(Integer id);
    void deleteCandidateById(Integer id);


    /**
     * kapcsolótáblás lekérdezés lenne
     */
    /*
    @Query( "SELECT c FROM Candidate c WHERE c.id = (SELECT course.id FROM Course course, Application application WHERE course.id = application.courseId)" )
    */
    List<Course> findCandidatesCourses(Candidate candidate);


}
