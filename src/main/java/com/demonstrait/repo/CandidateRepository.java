package com.demonstrait.repo;

import com.demonstrait.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Candidate findCandidateById(Integer id);
    void deleteCandidateByID(Integer id);

    Optional finddCandidateByID(Integer id);

}
