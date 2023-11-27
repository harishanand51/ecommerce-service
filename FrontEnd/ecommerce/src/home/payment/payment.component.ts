import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { HomeserviceService } from '../Services/homeservice.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent {
  constructor(private _snackBar: MatSnackBar,private router:Router,
    private homeservice:HomeserviceService,private http:HttpClient){
    
  }
  type = ["debit", "credit"];
  month = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
  year = ["2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"];
  PaymentGroup = new FormGroup({
    confirm_card: new FormControl('', Validators.required),
    new_card_name: new FormControl(""),
    new_card_type: new FormControl(""),
    new_card_expirydate_month: new FormControl(""),
    new_card_expirydate_year: new FormControl(""),
    card_no: new FormControl("")
  });
  save_payment(){
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + this.homeservice.token
    });
    let url="http://localhost:8082/makeTransaction";
    let req={
      "order": {
      "id": this.homeservice.orderId
  },
      "paymentMethod": this.PaymentGroup.controls.new_card_type.value
  }
  this.http.post(url,req,{ headers }).subscribe((res:any)=>{
    let snackBarRef =this._snackBar.open("Payment Successful & Order Placed", "Navigate to Home");
    snackBarRef.onAction().subscribe(() => {
      this.router.navigateByUrl("/home");
    });
  });
    
  }
}
