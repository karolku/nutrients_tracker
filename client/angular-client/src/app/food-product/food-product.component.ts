import { FoodProductService } from './../services/food-product.service';
import { Component, OnInit, DefaultIterableDiffer } from '@angular/core';

@Component({
  selector: 'app-food-product',
  templateUrl: './food-product.component.html',
  styleUrls: ['./food-product.component.scss']
})
export class FoodProductComponent implements OnInit {
  foods: any[];
  
  constructor(private service: FoodProductService) { 
  }

  ngOnInit() {
  }

  searchForProduct(input: HTMLInputElement) {
    this.service.searchFoodByName(input.value)
    .subscribe((response: any[]) => {
        this.foods = response;
        // this.posts = Array.of(this.posts);
    });
  }  

  createFoodProduct(input: HTMLInputElement){
    let post = {title: input.value};
    input.value = '';
    this.service.createFoodProduct(post)
        .subscribe((response: any) => {
          post['id'] = response.id;
          this.foods.splice(0,0, post);
          console.log(response);
        });
  }

  updatePost(post) {
      this.service.updateFoodProduct(post)
        .subscribe((response: any) => {
            console.log(response);
        });
  }
}
