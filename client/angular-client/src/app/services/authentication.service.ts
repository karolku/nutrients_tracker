import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public jwtHelper = new JwtHelperService();

  constructor(private http: HttpClient) {}

  login(credentials) {
    let contentTypeHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post("http://localhost:8080/api/authentication/login",
        JSON.stringify(credentials), {headers: contentTypeHeaders})
        .pipe(map((response : any) => {
            if(response && response.jwt) {
              this.storeUserInfo(response);
              return true;
            }
            return false;
        }));
  }
  
  singUp(signUpData): Observable<any> {
    console.log("Auth service: This is input from sign up component");
    console.log(signUpData);
    let contentTypeHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });
     return this.http.post("http://localhost:8080/api/authentication/signup",
        JSON.stringify(signUpData), {headers: contentTypeHeaders});
        // .pipe(map((response: any) => {
        //   console.log(response);
        // }));
  }

  decodeToken() {
    let token = localStorage.getItem('jwt');
    return this.jwtHelper.decodeToken(token);
  }

  getCurrentUserEmail() {
    let decodedToken = this.decodeToken();
    this.email = decodedToken.sub;
    return this.email;
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

  getUserInfoById() {
    let token = localStorage.getItem('jwt');
    let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
    });
    console.log('Message from auth service getUserById');
    console.log(token);
    console.log(headers);
    console.log(this.http.get('http://localhost:8080/api/users/' + this.id, {headers: headers}));
    return this.http.get('http://localhost:8080/api/users/' + this.id, {headers: headers});
  }

  storeUserInfo(user) {
    for(let key in user)
      localStorage.setItem(key, user[key]);
  }
}
