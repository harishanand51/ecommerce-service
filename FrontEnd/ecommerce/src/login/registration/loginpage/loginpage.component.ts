import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

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
    private fb: FormBuilder // Inject FormBuilder
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

    if (username === 'your_username' && password === 'your_password') {
      alert('Login successful!');
    } else {
      alert('Invalid username or password. Please try again.');
    }
  }

  forgot_password() {
    // Handle forgot password logic here
  }
  Register(){
    this._router.navigateByUrl("/register");
  }
}
