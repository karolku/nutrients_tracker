import { HomeComponent } from './home/home.component';
import { SettingsComponent } from './settings/settings.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {path: '', component: HomeComponent},
    {path: 'settings', component: SettingsComponent}
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
