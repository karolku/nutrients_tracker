import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FoodProductService {
  private url = 'https://jsonplaceholder.typicode.com/posts';
  
  constructor(private httpClient: HttpClient) { }

  getFoodProduct(){
    return this.httpClient.get(this.url);
  }

  createFoodProduct(post){
    return this.httpClient.post(this.url, JSON.stringify(post));
  }

  updateFoodProduct(post){
    return this.httpClient.put(this.url + '/' + post.id, JSON.stringify(post));
  }
}
