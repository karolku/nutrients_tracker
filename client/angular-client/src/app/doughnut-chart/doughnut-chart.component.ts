import { DataService } from './../services/shared/data.service';
import { DashboardComponent } from './../dashboard/dashboard.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-doughnut-chart',
  templateUrl: './doughnut-chart.component.html',
  styleUrls: ['./doughnut-chart.component.scss']
})
export class DoughnutChartComponent implements OnInit {

  nutrientsConsumed: any;
  constructor(private dashboard: DashboardComponent,
              private dataService: DataService){
  }

  ngOnInit(){
    this.dataService.sharedData.subscribe((data: any) => {
      this.nutrientsConsumed = data;
      this.updateChartData();
    });
  }

  public chartType: string = 'doughnut';

  public chartDatasets: Array<any> = [
    { data: [10, 10, 10], label: 'Macro Nutrients For Today' }
  ];

  public chartLabels: Array<any> = ['Protein', 'Fat', 'Carbohydrates'];

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

  updateChartData() {
    this.chartDatasets = [
      { data: [this.nutrientsConsumed?.protein,this.nutrientsConsumed?.fat, this.nutrientsConsumed?.carbohydrated], label: 'Macro nutrients for today' }
    ]
  }
}
