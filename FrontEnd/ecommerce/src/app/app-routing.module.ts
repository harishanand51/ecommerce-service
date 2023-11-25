import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from 'src/home/homepage/homepage.component';
import { LoginpageComponent } from 'src/login/registration/loginpage/loginpage.component';
import { RegisterpageComponent } from 'src/login/registration/registerpage/registerpage.component';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' }, // Set your home page route
  { path: 'home', component: HomepageComponent },
  {path:'login',component:LoginpageComponent},
  {path:'register',component:RegisterpageComponent}
  // Add more routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
