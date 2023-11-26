import { Component } from '@angular/core';
import { HomeserviceService } from '../Services/homeservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent {
  quantity_old: any;
  total_amount: any;
  
  constructor(public cart:HomeserviceService,private _router: Router){

  }
  
  ngOnInit(){
    this.calculate_total();
    
  }
  calculate_total(){
    this.total_amount=0;
    this.cart.results?.forEach((element: { quantity: number; price: number; }) => {
      if(element.quantity>0){
        this.total_amount += element.price*element.quantity;
      }
    })
  }
  changeQuantity( item: any, _quantity: any){
    // item.quantity=_quantity;
    // console.log(this.quantity);
    if(this.quantity_old<item.quantity){
      this.cart.total_items+=item.quantity-this.quantity_old;
      this.calculate_total();
    }else if(this.quantity_old>item.quantity){
      this.cart.total_items-=this.quantity_old-item.quantity;
      this.calculate_total();
    }
   
  }
  setoldvalue(_item:any){
    this.quantity_old=_item;
  }
  addItem(item: any){
    item.quantity++;
    this.cart.total_items++;
    this.calculate_total();
  }
  removeItem(item:any){
    if(item.quantity>0){
      item.quantity--;
      this.cart.total_items--;
      this.calculate_total();
    }  
  }
  checkout(){
    //this._router.navigate(['home/checkOut']);
    this.cart.disable_checkout_btn=true;
  }
  Backtoresults(){
    this._router.navigateByUrl("/home");
  }

}
