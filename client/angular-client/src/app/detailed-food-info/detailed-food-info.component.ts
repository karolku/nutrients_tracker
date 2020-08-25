import { FoodProductComponent } from './../food-product/food-product.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detailed-food-info',
  templateUrl: './detailed-food-info.component.html',
  styleUrls: ['./detailed-food-info.component.scss']
})
export class DetailedFoodInfoComponent implements OnInit {
  foodNutrients: any[];
  constructor(public food: FoodProductComponent) { }

  ngOnInit(): void {
  }

  getNutrientsInfo(nutrients) {
      this.foodNutrients = nutrients;
  }
}
