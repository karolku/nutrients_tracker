import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FoodProductService {
  private url = 'http://localhost:8080/api/usda/foods';
  public token: string;
  public authHeaders: any;

  constructor(private httpClient: HttpClient,) { }

  searchFoodByName(foodName){
    let token = localStorage.getItem('jwt');
    this.token = token;
    let authHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + token
  });
    this.authHeaders = authHeaders;
    console.log(authHeaders);
    console.log(this.httpClient.get(this.url + '/search/' + foodName, {headers: authHeaders}));
    return this.httpClient.get(this.url + '/search/' + foodName, {headers: authHeaders});
  }
}
