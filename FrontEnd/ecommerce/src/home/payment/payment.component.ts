import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent {
  constructor(private _snackBar: MatSnackBar,private router:Router){
    
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
    let snackBarRef =this._snackBar.open("Payment Successful & Order Placed", "Navigate to Home");
    snackBarRef.onAction().subscribe(() => {
      this.router.navigateByUrl("/home");
    });
  }
}
