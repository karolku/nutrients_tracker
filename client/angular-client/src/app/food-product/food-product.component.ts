import { FoodProductService } from './../services/food-product.service';
import { Component, OnInit, DefaultIterableDiffer } from '@angular/core';

@Component({
  selector: 'app-food-product',
  templateUrl: './food-product.component.html',
  styleUrls: ['./food-product.component.scss']
})
export class FoodProductComponent implements OnInit {
  posts: any[];
  
  constructor(private service: FoodProductService) { 
  }

  ngOnInit() {
     this.service.getFoodProduct()
          .subscribe((response: any[]) => {
              this.posts = response;
              // this.posts = Array.of(this.posts);
          });
  }

  createFoodProduct(input: HTMLInputElement){
    let post = {title: input.value};
    input.value = '';
    this.service.createFoodProduct(post)
        .subscribe((response: any) => {
          post['id'] = response.id;
          this.posts.splice(0,0, post);
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
