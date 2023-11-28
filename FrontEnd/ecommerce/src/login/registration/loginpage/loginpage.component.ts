import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { HomeserviceService } from 'src/home/Services/homeservice.service';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.scss']
})
export class LoginpageComponent implements OnInit {
  hidePassword: boolean = true;

  loginFormGroup!: FormGroup;
  forgotPasswordGroup!: FormGroup;


  constructor(
    private _router: Router,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private fb: FormBuilder,
    private http:HttpClient,
    private homeservice:HomeserviceService
    // Inject FormBuilder
  ) {}

  ngOnInit(): void {
    this.loginFormGroup = this.fb.group({
      UsernameCtrl: ['', [Validators.required, Validators.email]],
      PasswordCtrl: ['', [Validators.required]],
      remember: [false],
    });

    this.forgotPasswordGroup = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
    });

    this.loginFormGroup.controls['UsernameCtrl'].setValue('');
    this.loginFormGroup.controls['PasswordCtrl'].setValue('');

  }

  login() {
    // Here you can add your login logic using this.loginFormGroup.value
    const username = this.loginFormGroup.value.UsernameCtrl;
    const password = this.loginFormGroup.value.PasswordCtrl;
    const credentials = btoa(`${username}:${password}`);
    let url = "http://localhost:8082/login";
    
    const headers = new HttpHeaders({
      'Authorization': `Basic ${credentials}`
    })
    this.http.get(url,{headers:headers}).subscribe((res:any)=>{
      if(res.token){
      this.homeservice.token=res.token;
      this.homeservice.isUser_Login=true;
      alert('Login successful!');
      this._router.navigateByUrl("/home");
    }
    },err=>{
      
      alert('Invalid username or password. Please try again.');
    });
    
    // if (username === 'your_username' && password === 'your_password') {
      
    // } else {
      
    // }
  }

  forgot_password() {
    // Handle forgot password logic here
  }
  Register(){
    this._router.navigateByUrl("/register");
  }
  navigatehome(){
    this._router.navigateByUrl('/home');
  }
}
