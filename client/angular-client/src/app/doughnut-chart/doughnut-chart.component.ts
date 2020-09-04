import { DashboardComponent } from './../dashboard/dashboard.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-doughnut-chart',
  templateUrl: './doughnut-chart.component.html',
  styleUrls: ['./doughnut-chart.component.scss']
})
export class DoughnutChartComponent {
  nutrientsConsumed = {
    'fat': 0,
    'protein': 0,
    'carbohydrated': 0
  }
  
  constructor(private dashboard: DashboardComponent){
  }

  public chartType: string = 'doughnut';

  public chartDatasets: Array<any> = [
    { data: [this.nutrientsConsumed.fat, this.nutrientsConsumed.protein, this.nutrientsConsumed.carbohydrated], label: 'Macro Nutrients For Today' }
  ];

  public chartLabels: Array<any> = ['CarboHydrates', 'Protein', 'Fat'];

  public chartColors: Array<any> = [
    {
      backgroundColor: ['#F7464A', '#46BFBD', '#FDB45C', '#949FB1', '#4D5360'],
      hoverBackgroundColor: ['#FF5A5E', '#5AD3D1', '#FFC870', '#A8B3C5', '#616774'],
      borderWidth: 2,
    }
  ];

  public chartOptions: any = {
    responsive: true
  };
  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }
}
