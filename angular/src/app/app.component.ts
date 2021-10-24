import { Component, OnInit } from '@angular/core';
import { Candidate } from './candidate';
import { CandidateService } from './candidate.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'newlabvezmanagerapp';
  public candidates: Candidate[];
  
  constructor(private candidateService: CandidateService){}
  
  ngOnInit() {
	  this.getCandidates();
  }
  
  public getCandidates(): void{
	  this.candidateService.getCandidates().subscribe(
	  (response: Candidate[]) => {
		  this.candidates = response;
	  },
	  (error: HttpErrorResponse) => {
		  alert(error.message);
	  }
	 );
  }
}
