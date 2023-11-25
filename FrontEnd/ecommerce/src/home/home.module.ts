import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatChipsModule } from '@angular/material/chips';
import { MatCardModule } from '@angular/material/card';
import { MatPaginatorModule } from '@angular/material/paginator'; // Add MatPaginatorModule here

import { PaymentDetailsComponent } from './payment-details/payment-details.component';


import { HomepageComponent } from './homepage/homepage.component';
import { ProductdetailsComponent } from './productdetails/productdetails.component';
import { ReviewComponent } from './review/review.component';
import { CartComponent } from './cart/cart.component';

@NgModule({
  declarations: [HomepageComponent, ProductdetailsComponent, ReviewComponent
  ,CartComponent,
  PaymentDetailsComponent,], // Declare HomepageComponent
  imports: [
    CommonModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatInputModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatChipsModule,
    MatCardModule,
    MatPaginatorModule // Include MatPaginatorModule in the imports array
  ],
  
 
  
  exports:[
    CartComponent,
    PaymentDetailsComponent,
    HomepageComponent
  ]
})
export class HomeModule { }