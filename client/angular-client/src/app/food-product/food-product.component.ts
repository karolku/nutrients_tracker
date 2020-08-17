import { Component, OnInit } from '@angular/core';
import {HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-food-product',
  templateUrl: './food-product.component.html',
  styleUrls: ['./food-product.component.scss']
})
export class FoodProductComponent {
  constructor(HttpClient: HttpClient) { }

}
