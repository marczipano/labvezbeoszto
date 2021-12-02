package com.demonstrait.service;

import com.demonstrait.model.Candidate;
import com.demonstrait.model.Course;
import com.demonstrait.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CandidateService {

    private static CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }


    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate findCandidateById(@PathVariable Integer id) {
        return candidateRepository.findCandidateById(id);
    }

    public List<String> findCandidatesCourses(Integer cid) {
        return candidateRepository.findCandidatesCourses(cid);
    }


    public Candidate addCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }


    public static void deleteCandidate(Integer id){
        candidateRepository.deleteCandidateById(id);

    }

    public static CandidateRepository getCandidateRepository() {
        return candidateRepository;
    }

    public static void setCandidateRepository(CandidateRepository candidateRepository) {
        CandidateService.candidateRepository = candidateRepository;
    }


}