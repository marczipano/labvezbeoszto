package com.demonstrait.controller;


import com.demonstrait.model.Candidate;
import com.demonstrait.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {


    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidate(){
        List<Candidate> candidates = candidateService.getCandidates();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @GetMapping(path ="{id}")
    public ResponseEntity<Candidate> getCandidateByID(@PathVariable("id") Integer id){
        Candidate candidate = candidateService.findCandidateById(id);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Candidate> addCandidate(@Validated @RequestBody Candidate candidate){
        Candidate newcandidate = candidateService.addCandidate(candidate);
        return new ResponseEntity<>(newcandidate, HttpStatus.CREATED);
    }

    /*
    @PostMapping
    public ResponseEntity<Candidate> addCandidateWithValues(@RequestParam String first,
                                                  @RequestParam String last,
                                                  @RequestParam String email,
                                                  @RequestParam String phone){
        Candidate newcandidate = candidateService.addCandidateWithValues(first, last, email, phone);
        return new ResponseEntity<>(newcandidate, HttpStatus.CREATED);
    }
    */

    @PutMapping
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate){
        Candidate updateCandidate = candidateService.updateCandidate(candidate);
        return new ResponseEntity<>(updateCandidate, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping (path ="{id}")
    public ResponseEntity<Candidate> deleteCandidate(@PathVariable("id") Integer id){
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
