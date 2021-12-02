package com.demonstrait.repo;

import com.demonstrait.model.Candidate;
import com.demonstrait.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Candidate findCandidateById(Integer id);
    void deleteCandidateById(Integer id);

    @Query( value = "SELECT c.name FROM Course c WHERE c.id in(SELECT course_id FROM Application a WHERE a.candidate_id = :cid)", nativeQuery = true)
    List<String> findCandidatesCourses(@Param("cid") Integer cid);


}
