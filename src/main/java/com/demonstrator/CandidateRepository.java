package com.demonstrator;

import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

    Candidate findCandidateById(Integer id);
}
