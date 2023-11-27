import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { HomeserviceService } from '../Services/homeservice.service';

@Component({
  selector: 'app-productdetails',
  templateUrl: './productdetails.component.html',
  styleUrls: ['./productdetails.component.scss']
})
export class ProductdetailsComponent {
  //CardData: any;
   @Input() CardData: any;
   @Output() isBack: EventEmitter<boolean> = new EventEmitter<boolean>();
  reviews: any;
  CardDatarating: any;
   
  constructor(public http:HttpClient,public homeservice:HomeserviceService){}
  showReviewSection:boolean=false;
  allreviews:any=[];
  ngOnInit(){
    let url="http://localhost:8082/getReviews/6";
    this.http.get(url).subscribe((res:any)=>{
      this.reviews=res[0];
      this.allreviews=res;
      this.CardDatarating=0
      for(let i=0;i<res.length;i++){
        this.CardDatarating+= res[i].rating;
      }
      this.CardDatarating=this.CardDatarating/res.length;
    });
    console.log(this.CardData);
  }
  navigate(event: any){
    this.isBack.emit(true);
  }
  showrating(){
    this.showReviewSection=true;
  }
}
