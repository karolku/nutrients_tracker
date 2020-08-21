import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) {}

  login(credentials) {
    let contentTypeHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post("http://localhost:8080/api/authentication",
        JSON.stringify(credentials), {headers: contentTypeHeaders})
        .pipe(map((response : any) => {
            console.log(response);
        }));
  }

  logout() {
  }

  isLoggedIn() {
    return false;
  }
}
