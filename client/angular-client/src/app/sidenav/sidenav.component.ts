import { Component, OnInit } from '@angular/core';
import { faHome, faCogs, faUser, faChartLine } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {
  HomeIcon = faHome;
  UserIcon = faUser;
  SettingsIcon = faCogs;
  ChartIcon = faChartLine;

  constructor() { }

  ngOnInit(): void {
  }

}
