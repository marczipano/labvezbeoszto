package com.demonstrait.service;

import com.demonstrait.model.Candidate;
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


    public Candidate addCandidateWithValues(
            String first,
            String last,
            String email,
            String phone) {
        Candidate candidate = new Candidate();
        candidate.setFirstName(first);
        candidate.setLastName(last);
        candidate.setEmail(email);
        candidate.setPhone(phone);
        candidate.setId((int)(Math.random()*100));

        candidateRepository.save(candidate);

        return candidate;
    }

    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate findCandidateById(@PathVariable Integer id) {
        return candidateRepository.findCandidateById(id);
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
}