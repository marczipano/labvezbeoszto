package com.demonstrait.repo;

import com.demonstrait.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Candidate findCandidateById(Integer id);
    void deleteCandidateById(Integer id);



}
