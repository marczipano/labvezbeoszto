package com.demonstrait;


import com.demonstrait.model.Candidate;
import com.demonstrait.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateResource {
    private final CandidateService candidateService;

    public CandidateResource(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Candidate>> getAllCandidate(){
        List<Candidate> candidates = candidateService.getCandidates();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Candidate> getCandidateByID(@PathVariable("id") Integer id){
        Candidate candidate = candidateService.findCandidateById(id);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate){
        Candidate newcandidate = candidateService.addCandidate(candidate);
        return new ResponseEntity<>(newcandidate, HttpStatus.CREATED);
    }


    @PostMapping("/addd")
    public ResponseEntity<Candidate> addCandidateWithValues(@RequestParam String first,
                                                  @RequestParam String last,
                                                  @RequestParam String email,
                                                  @RequestParam String phone){
        Candidate newcandidate = candidateService.addCandidateWithValues(first, last, email, phone);
        return new ResponseEntity<>(newcandidate, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate){
        Candidate updateCandidate = candidateService.addCandidate(candidate);
        return new ResponseEntity<>(updateCandidate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable("id") Integer id){
        CandidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
