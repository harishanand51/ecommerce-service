import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { ProductdetailsComponent } from '../productdetails/productdetails.component';
import { HomeserviceService } from '../Services/homeservice.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent {
  cardDataList=[
    {"image":"https://material.angular.io/assets/img/examples/shiba2.jpg",
    "desc":"The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan.A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was originallybred for hunting.",
    "price":"10$",
    "rating":"4",
    "productid":"201"
  },
    {},{},{},{},{},{},{},{},{},{},{},{},{},{}];
  page:number = 1; // Initial page
  pageSize = 5; // Initial page size
  searchForm = new FormGroup({
    searchInput: new FormControl(''),
  });
  
  cardDataselected: any;
 
  showProductDetails: boolean=false;
  Card_Data: any;
  constructor(private router: Router,public homeservice:HomeserviceService) {}

  search(){
    const searchTerm = this.searchForm.controls.searchInput.value
    // You can perform your search logic here, e.g., make an API request or filter data.
    console.log('Search term:', searchTerm);
  }
  addtoCart(){

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
}


