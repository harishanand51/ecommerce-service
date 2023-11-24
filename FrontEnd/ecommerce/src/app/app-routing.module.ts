import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from 'src/home/homepage/homepage.component';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' }, // Set your home page route
  { path: 'home', component: HomepageComponent },
  
  // Add more routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
