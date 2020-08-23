import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  date;

  constructor() { }

  ngOnInit(): void {
  }

  isDateValid(){
    return moment(this.date,"YYYY-MM-DD");
  }

  display(){
    console.log(this.date);
  }
}
