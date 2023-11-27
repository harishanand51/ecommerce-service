import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HomeserviceService } from 'src/home/Services/homeservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ecommerce';
  constructor(private http:HttpClient,public homeservice:HomeserviceService){
    let url2="http://localhost:8082/dummyapi"
    this.http.get(url2).subscribe((res:any)=>{
      this.homeservice.cartId=res;
    },err=>{});
  }
}
