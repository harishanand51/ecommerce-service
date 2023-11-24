import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-productdetails',
  templateUrl: './productdetails.component.html',
  styleUrls: ['./productdetails.component.scss']
})
export class ProductdetailsComponent {
  //CardData: any;
   @Input() CardData: any;
   @Output() isBack: EventEmitter<boolean> = new EventEmitter<boolean>();
   reviews=[
    {"username":"abc","rating":4,"comment":"comment"},
    {"username":"abc","rating":3,"comment":"comment"},
    {"username":"abc","rating":2,"comment":"comment"},
    {"username":"abc","rating":5,"comment":"comment"}
  ];
  showReviewSection:boolean=false;
  ngOnInit(){
    console.log(this.CardData);
  }
  navigate(event: any){
    this.isBack.emit(true);
  }
  showrating(){
    this.showReviewSection=true;
  }
}
