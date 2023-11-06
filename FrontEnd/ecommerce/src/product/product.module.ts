import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductdetailsComponent } from './productdetails/productdetails.component';



@NgModule({
  declarations: [
    ProductdetailsComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    ProductdetailsComponent
  ]
})
export class ProductModule { }
