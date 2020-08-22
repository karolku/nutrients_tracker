import { AuthenticationService } from './../services/authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(public auth: AuthenticationService) { }

  ngOnInit(): void {
  }

}
