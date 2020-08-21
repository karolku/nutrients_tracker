import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) {}

  login(credentials) {
    return this.http.post("http://localhost:8080/api/authentication",
        JSON.stringify(credentials));
  }
}
