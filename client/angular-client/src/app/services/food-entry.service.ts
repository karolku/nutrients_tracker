import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FoodEntryService {
  private url = 'http://localhost:8080/api/foodEntry';

  constructor(private httpClient: HttpClient) { }

  createFoodEntry(entryData) {
    let token = localStorage.getItem('jwt');

    let authHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + token
  });
    console.log('FoodEntry object send by the service');
    console.log(entryData);
    console.log(this.httpClient.post(this.url, JSON.stringify(entryData), {headers: authHeaders}));
    this.httpClient.post(this.url, JSON.stringify(entryData), {headers: authHeaders});
  }
}
