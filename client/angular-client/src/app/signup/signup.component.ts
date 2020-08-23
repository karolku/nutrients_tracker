import { AuthenticationService } from './../services/authentication.service';
import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor(private auth: AuthenticationService,
              private router: Router) { }

  ngOnInit(): void {
  }

  signUp(signUpData){
    console.log(signUpData);
    this.auth.singUp(signUpData)
    .subscribe((respone: any) => {
        console.log(respone);
        this.router.navigate(['/login']);
    })
  }
}
