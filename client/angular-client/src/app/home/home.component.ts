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

  constructor(public auth: AuthenticationService) { }

  ngOnInit(): void {
  }
}
