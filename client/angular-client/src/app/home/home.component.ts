import { FoodEntryService } from './../services/food-entry.service';
import { AuthenticationService } from './../services/authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  currentUser = {
    id: localStorage.getItem('id'),
    firstName: localStorage.getItem('firstName'),
    lastName: localStorage.getItem('lastName'),
    gender: localStorage.getItem('gender'),
    birthdayDate: localStorage.getItem('birthdayDate'),
    email: localStorage.getItem('email'),
    weightInKg: localStorage.getItem('weightInKg'),
    heightInCm: localStorage.getItem('heightInCm'),
    activityLevel: localStorage.getItem('activityLevel'),
    caloriesDemand: localStorage.getItem('caloriesDemand')
  }
  food: any;
  foodsNutrients: any[];
  constructor(public auth: AuthenticationService, public foodEntryService: FoodEntryService) { }

  ngOnInit(): void {
  }

  receiveFoodNutrientsData($event) {
    this.food = $event;
    this.foodsNutrients = this.food.foodNutrients;
    console.log('Data received from the child');
    console.log(this.food);
  }

  sendFoodEntry(foodEntry) {
    foodEntry.userId = localStorage.getItem('id');
    foodEntry.servingType = "gram";
    foodEntry.fdcId = this.food.fdcId;
    console.log(foodEntry);
    this.foodEntryService.createFoodEntry(foodEntry);
  }
}
