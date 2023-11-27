import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeserviceService {
  total_items: number=0;
  results: any;
  disable_checkout_btn: boolean=false;
  token:any;
  cartId:any;
  cart_results:any;
  orderId:any;
  
  constructor() { }
  public isUser_Login:boolean=false;
}
