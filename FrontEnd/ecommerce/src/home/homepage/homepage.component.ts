import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { ProductdetailsComponent } from '../productdetails/productdetails.component';
import { HomeserviceService } from '../Services/homeservice.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent {
  cardDataList:any=[];
  page:number = 1; // Initial page
  pageSize = 5; // Initial page size
  searchForm = new FormGroup({
    searchInput: new FormControl(''),
  });
  
  cardDataselected: any;
 
  showProductDetails: boolean=false;
  Card_Data: any;
  categories: any;
  constructor(private router: Router,public homeservice:HomeserviceService,private http:HttpClient) {}
  ngOnInit(){
    let url="http://localhost:8082/Allproducts"
    this.http.get(url).subscribe((res:any)=>{
      this.cardDataList=res;
      this.homeservice.results=this.cardDataList;
    },err=>{});
    let url1="http://localhost:8082/getCategories"
    this.http.get(url1).subscribe((res:any)=>{
      this.categories=res;
    },err=>{});
    let url2="http://localhost:8082/dummyapi"
    this.http.get(url1).subscribe((res:any)=>{
      this.homeservice.cartId=res;
    },err=>{});
  }
  search(){
    const searchTerm = this.searchForm.controls.searchInput.value
    let url="http://localhost:8082/product/"+searchTerm;
    this.http.get(url).subscribe((res:any)=>{
      this.cardDataList=res;
      this.homeservice.results=this.cardDataList;
    },err=>{});
    // You can perform your search logic here, e.g., make an API request or filter data.
    console.log('Search term:', searchTerm);
  }
  addtoCart(data:any){
    let url="http://localhost:8082/addProductToCart/";
    let req={
      "product": {
          "id": data.id,
          "productName": data.productName,
          "description": data.description,
          "price": data.price,
          "stockQuantity": data.stockQuantity
      },
      "cart": {
          "id": this.homeservice.cartId,
          "cart_total": ""
      },
      "quantity": "1"
  }
  this.http.post(url,req).subscribe((res:any)=>{
    this.call_getcart();
  });

  }
  call_getcart(){
    let url="http://localhost:8082/getProductsInCart/"+this.homeservice.cartId;
    this.http.get(url).subscribe((res)=>{
      this.cardDataList=res;
      this.homeservice.results=this.cardDataList;
    })
  }
  NavigateCart(){
    this.router.navigateByUrl('/cart');
  }
  product_details(cardData: any, event: Event) {
    this.showProductDetails=true;
    this.Card_Data=cardData;
  }
  
  getVisibleCards() {
    const startIndex = (this.page - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    return this.cardDataList.slice(startIndex, endIndex);
  }
  onPageChange(event: PageEvent) {
    this.page = event.pageIndex + 1;
    this.pageSize = event.pageSize;
    this.getVisibleCards();
  }
  goBack(event: any){
    if(event){
      this.showProductDetails=false;
    }
  }
  login(){
    this.homeservice.isUser_Login=true;
    this.router.navigateByUrl("/login");
  }
  select_category(cat:any){
    let url="http://localhost:8082/getAllProductsinCategory";
    let req={
      "id": cat.id,
      "categoryName": cat.categoryName
  }
  this.http.post(url,req).subscribe((res)=>{
    this.cardDataList=res;
      this.homeservice.results=this.cardDataList;
  })
  }
}


