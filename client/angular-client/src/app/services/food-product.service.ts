import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FoodProductService {
  private url = 'http://localhost:8080/api/usda/foods';
  private token = localStorage.getItem('jwt');

  private authHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authentication': 'Bearer ' + this.token
  });

  constructor(private httpClient: HttpClient,) { }

  searchFoodByName(foodName){
    return this.httpClient.get(this.url + '/search' + foodName, { headers: this.authHeaders });
  }

  createFoodProduct(post){
    return this.httpClient.post(this.url, JSON.stringify(post));
  }

  updateFoodProduct(post){
    return this.httpClient.put(this.url + '/' + post.id, JSON.stringify(post));
  }
}
