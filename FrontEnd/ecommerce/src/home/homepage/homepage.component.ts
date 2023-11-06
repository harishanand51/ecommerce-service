import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent {
  cardDataList=[{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}];
  page:number = 1; // Initial page
  pageSize = 5; // Initial page size
  searchForm = new FormGroup({
    searchInput: new FormControl(''),
  });
  search(){
    const searchTerm = this.searchForm.controls.searchInput.value
    // You can perform your search logic here, e.g., make an API request or filter data.
    console.log('Search term:', searchTerm);
  }
  addtoCart(){

  }
  product_details(){}
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
}


