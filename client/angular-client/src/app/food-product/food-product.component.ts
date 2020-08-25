import { DetailedFoodInfoComponent } from './../detailed-food-info/detailed-food-info.component';
import { FoodProductService } from './../services/food-product.service';
import { Component, OnInit, DefaultIterableDiffer, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-food-product',
  templateUrl: './food-product.component.html',
  styleUrls: ['./food-product.component.scss']
})
export class FoodProductComponent implements OnInit {
  foods: any[];
  food: any;
  @Output() eventMessage = new EventEmitter<any[]>();
  constructor(private service: FoodProductService) { 
  }

  ngOnInit() {
  }
  
  searchForProduct(input: HTMLInputElement) {
    this.service.searchFoodByName(input.value)
    .subscribe((response: any[]) => {
        this.foods = response;
        console.log(response);
        // this.posts = Array.of(this.posts);
    });
  }  

  sendNutrients(dataFromView){
    this.food = dataFromView;
    this.eventMessage.emit(this.food);
  }
}
