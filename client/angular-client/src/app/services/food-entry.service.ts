import { FoodProductService } from './food-product.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FoodEntryService {
  private url = 'http://localhost:8080/api/foodEntry';

  constructor(private httpClient: HttpClient, private foodService: FoodProductService) { }

  createFoodEntry(entryData) {
    console.log('FoodEntry object send by the service');
    console.log(entryData);
    console.log('Data from food service');
    console.log(this.foodService.authHeaders);
    console.log(this.foodService.token);
    console.log(this.httpClient.post(this.url, JSON.stringify(entryData), {headers: this.foodService.authHeaders}));
    return this.httpClient.post(this.url, JSON.stringify(entryData), {headers: this.foodService.authHeaders});
  }
}
