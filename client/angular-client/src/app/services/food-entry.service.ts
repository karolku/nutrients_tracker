import { FoodProductService } from './food-product.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FoodEntryService {
  private url = 'http://localhost:8080/api/foodEntry';
  private urlFoodsNutrients = 'http://localhost:8080/api/foodsNutrients';

  constructor(private httpClient: HttpClient, private foodService: FoodProductService) { }

  createFoodEntry(entryData) {
    return this.httpClient.post(this.url, JSON.stringify(entryData), {headers: this.foodService.authHeaders});
  }

  getFoodEntryByUserIdAndDate(date) {
      let userId = parseInt(localStorage.getItem('id'));
      let token = localStorage.getItem('jwt');
      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
      })
      return this.httpClient.get(this.urlFoodsNutrients + '/user/' + userId + '/date/' + date, {headers: headers});
  }
}
