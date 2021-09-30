package com.demonstrait;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/add")
    public String addCandidate(
            @RequestParam String first,
            @RequestParam String last,
            @RequestParam String email,
            @RequestParam String phone) {
        Candidate candidate = new Candidate();
        candidate.setFirstName(first);
        candidate.setLastName(last);
        candidate.setEmail(email);
        candidate.setPhone(phone);

        candidateRepository.save(candidate);

        return "Jelentkező hozzáadva!";
    }

    @GetMapping("/list")
    public Iterable<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Candidate findCandidateById(@PathVariable Integer id) {
        return candidateRepository.findCandidateById(id);
    }
}