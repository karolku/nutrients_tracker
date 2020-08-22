import { AuthenticationService } from './../services/authentication.service';
import { Component, OnInit } from '@angular/core';
import { faHome, faCogs, faUser, faChartLine } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.scss']
})
export class SidenavComponent implements OnInit {
  HomeIcon = faHome;
  UserIcon = faUser;
  SettingsIcon = faCogs;
  ChartIcon = faChartLine;

  constructor(private auth: AuthenticationService) { }

  ngOnInit(): void {
  }

}
