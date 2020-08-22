import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FoodProductService {
  private url = 'http://localhost:8080/api/usda/foods';
  

  constructor(private httpClient: HttpClient,) { }

  searchFoodByName(foodName){
    let token = localStorage.getItem('jwt');

    let authHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + token
  });
    console.log(authHeaders);
    console.log(this.httpClient.get(this.url + '/search/' + foodName, {headers: authHeaders}));
    return this.httpClient.get(this.url + '/search/' + foodName, {headers: authHeaders});
  }

  createFoodProduct(post){
    return this.httpClient.post(this.url, JSON.stringify(post));
  }

  updateFoodProduct(post){
    return this.httpClient.put(this.url + '/' + post.id, JSON.stringify(post));
  }
}
