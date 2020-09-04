import { DataService } from './../services/shared/data.service';
import { FoodEntryService } from './../services/food-entry.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  foodEntries: any[];
  foodInfo: any[] = [];
  isEntryEmpty: boolean;
  nutrientsConsumed: any;
  caloriesDemand = localStorage.getItem('caloriesDemand');

  constructor(private foodEntryService: FoodEntryService,
              private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.sharedData.subscribe(data => this.nutrientsConsumed = data);
  }

  updateSharedData() {
    this.dataService.nextData(this.nutrientsConsumed);
  }

  public chartType: string = 'bar';

  public chartDatasets: Array<any> = [
    { data: [1500, 2200, 1800, 1900, 2100, 1950, 2100], label: 'Calories for this week' }
  ];

  public chartLabels: Array<any> = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];

  public chartColors: Array<any> = [
    {
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 3,
    }
  ];

  public chartOptions: any = {
    responsive: true
  };
  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }


  getFoodEntriesByDateAndUserId(date) {
    this.foodEntryService.getFoodEntryByUserIdAndDate(date)
      .subscribe((response: any) => {
        this.foodEntries = response.foodEntryList;
        this.nutrientsConsumed = response.nutrientsConsumed;
        console.log(this.foodEntries);
        console.log(this.nutrientsConsumed);
        if(this.foodEntries.length === 0)
            this.isEntryEmpty = true;
        else {
          this.isEntryEmpty = false;
          this.updateSharedData();
        }
      })
  }
}
