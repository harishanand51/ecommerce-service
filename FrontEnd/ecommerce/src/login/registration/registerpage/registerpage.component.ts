import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registerpage',
  templateUrl: './registerpage.component.html',
  // styleUrls: ['./registerpage.component.css']
})
export class RegisterpageComponent implements OnInit {
  // registerForm!: FormGroup; // Use ! to indicate it will be initialized in ngOnInit
  hidePassword: boolean = false; // Add this line

  
  constructor(private formBuilder: FormBuilder,private http:HttpClient,private router:Router) {}
  registerForm = this.formBuilder.group({
    emailCtrl: ['', [Validators.required, Validators.email]],
    passwordCtrl: ['', [Validators.required, Validators.minLength(6)]],
    mobileCtrl: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
    addressCtrl: ['', Validators.required],
    firstNameCtrl:[''],
    lastNameCtrl:['']
    // Add more form controls as needed
  });
  ngOnInit(): void {
    
  }

  onRegisterSubmit(): void {
    if (this.registerForm && this.registerForm.valid) {
      let url="http://localhost:8082/register";
      let req={
       "firstName": this.registerForm.controls.firstNameCtrl.value,
       "lastName": this.registerForm.controls.lastNameCtrl.value,
       "email":this.registerForm.controls.emailCtrl.value,
       "password": this.registerForm.controls.passwordCtrl.value,
       "phone":this.registerForm.controls.mobileCtrl.value,
       "address": this.registerForm.controls.addressCtrl.value
     }
     this.http.post(url,req,{  responseType: 'text' }).subscribe((res: string)=>{
       if(res==="Customer Created"){
         this.router.navigateByUrl("/login");
       }
     },err=>{
       this.registerForm.reset();
     })
   
    }
  }
}
