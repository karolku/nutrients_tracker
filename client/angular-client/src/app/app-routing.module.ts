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
    {path: 'settings', component: SettingsComponent},
    {path: 'dashboard', component: DashboardComponent}
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
