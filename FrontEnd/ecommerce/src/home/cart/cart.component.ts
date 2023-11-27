import { Component } from '@angular/core';
import { HomeserviceService } from '../Services/homeservice.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent {
  quantity_old: any;
  total_amount: any;
  
  constructor(public cart:HomeserviceService,private _router: Router,private http:HttpClient){

  }
  
  ngOnInit(){
    this.calculate_total();
    
  }
  
  calculate_total(){
    this.total_amount=0;
    let url="http://localhost:8082/getProductsInCart/"+this.cart.cartId;
    this.http.get(url).subscribe((res:any)=>{
      
      this.cart.cart_results=res;
      this.cart.total_items=res.length;
      this.cart.cart_results?.forEach((element: { quantity: number; product: any; }) => {
        if(element.quantity>0){
          this.total_amount += element.product.price*element.quantity;
        }
      });
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
    
      let url="http://localhost:8082/addProductToCart";
      let req={
        "product": {
            "id": item.product.id,
            "productName": item.product.productName,
            "description": item.product.description,
            "price": item.product.price,
            "stockQuantity": item.product.stockQuantity
        },
        "cart": {
            "id": this.cart.cartId,
            "cart_total": ""
        },
        "quantity": item. _quantity
    }
    this.http.post(url,req).subscribe((res:any)=>{
      this.cart.cart_results=res;
    });
    this.calculate_total();
  }
  setoldvalue(_item:any){
    this.quantity_old=_item;
  }
  addItem(item: any){
      let url="http://localhost:8082/addProductToCart";
      let req={
        "product": {
            "id": item.product.id,
            "productName": item.product.productName,
            "description": item.product.description,
            "price": item.product.price,
            "stockQuantity": item.product.stockQuantity
        },
        "cart": {
            "id": this.cart.cartId,
            "cart_total": ""
        },
        "quantity": item.quantity+1
    }
    this.http.post(url,req).subscribe((res:any)=>{
      this.cart.cart_results=res;
    });
    this.cart.total_items++;
    setTimeout(() => {
      this.calculate_total(); // Replace with the function you want to call
    }, 2000);
    
  }
  removeItem(item:any){
    if(item.quantity>1){
      this.cart.total_items--;
      this.calculate_total();
      let url="http://localhost:8082/addProductToCart";
      let req={
        "product": {
            "id": item.product.id,
            "productName": item.product.productName,
            "description": item.product.description,
            "price": item.product.price,
            "stockQuantity": item.product.stockQuantity
        },
        "cart": {
            "id": this.cart.cartId,
            "cart_total": ""
        },
        "quantity": item.quantity-1
    }
    this.http.post(url,req).subscribe((res:any)=>{
      this.cart.cart_results=res;
    });
    setTimeout(() => {
      this.calculate_total(); // Replace with the function you want to call
    }, 2000);
  }
    else{
      let url="http://localhost:8082/removeProductFromCart";
      let req={
        "product": {
          "id": item.product.id,
          "productName": item.product.productName,
          "description": item.product.description,
          "price": item.product.price,
          "stockQuantity": item.product.stockQuantity
      },
        "cart": {
            "id": this.cart.cartId,
            "cart_total": ""
        }
    }
    this.http.post(url,req).subscribe((res:any)=>{
      if(res==="Product removed from the cart successfully"){
        
    }
  });
    setTimeout(() => {
      this.calculate_total(); // Replace with the function you want to call
    }, 2000);
    
    
    }

    
  }
  checkout(){
    this._router.navigateByUrl('/payment');
    this.cart.disable_checkout_btn=true;
  }
  Backtoresults(){
    this._router.navigateByUrl("/home");
  }

}
