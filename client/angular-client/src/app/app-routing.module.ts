import { AuthGuardService } from './services/auth-guard.service';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { SettingsComponent } from './settings/settings.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {path: '', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'settings', component: SettingsComponent, canActivate: [AuthGuardService]},
    {path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuardService]}
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
