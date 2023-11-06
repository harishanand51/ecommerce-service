import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from 'src/home/homepage/homepage.component';
import { ProductdetailsComponent } from 'src/product/productdetails/productdetails.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' }, // Set your home page route
  { path: 'home', component: HomepageComponent },
  { path: 'details', component: ProductdetailsComponent },
  // Add more routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
