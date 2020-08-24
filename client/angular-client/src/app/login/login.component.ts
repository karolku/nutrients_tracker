import { HomeComponent } from './../home/home.component';
import { NavbarComponent } from './../navbar/navbar.component';
import { AppRoutingModule } from './../app-routing.module';
import { RouterModule, Router } from '@angular/router';
import { AuthenticationService } from './../services/authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  invalidLogin: boolean;

  constructor(private auth: AuthenticationService,
              private router: Router,
              private home: HomeComponent) { }

  ngOnInit(): void {
  }

  signIn(credentials){
    this.auth.login(credentials)
      .subscribe((response: any) => {
        if(response)
          this.router.navigate(['/home']);
        else
          this.invalidLogin = true;
      });
  }
}
