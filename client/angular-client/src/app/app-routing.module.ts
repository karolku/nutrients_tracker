import { SettingsComponent } from './settings/settings.component';
import { MainComponent } from './main/main.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {path: '', component: MainComponent},
    {path: 'settings', component: SettingsComponent}
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
