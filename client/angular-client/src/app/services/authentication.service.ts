import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public userName: string;

  constructor(private http: HttpClient) {}

  login(credentials) {
    let contentTypeHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post("http://localhost:8080/api/authentication/login",
        JSON.stringify(credentials), {headers: contentTypeHeaders})
        .pipe(map((response : any) => {
            if(response && response.jwt) {
              this.userName = response.username;
              localStorage.setItem('jwt', response.jwt)
              return true;
            }
            return false;
        }));
  }

  logout() {
    localStorage.removeItem('jwt');
  }

  isLoggedIn() {
    let jwtHelper = new JwtHelperService();
    let token = localStorage.getItem('jwt');
    if(!token)
      return false;
    let isExpired = jwtHelper.isTokenExpired(token);
    return !isExpired;
  }
}
