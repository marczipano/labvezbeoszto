import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Candidate } from './candidate';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {
	
	private apiServerUrl = environment.apiBaseUrl;
	
	
  constructor(private http: HttpClient) { }
  
  public getCandidates(): Observable<any> {
	  return this.http.get<any>(`${this.apiServerUrl}/candidate/all`);
	  
	  
  }
}
