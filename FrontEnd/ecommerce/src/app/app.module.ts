import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeModule } from 'src/home/home.module';
import { LocationStrategy, PathLocationStrategy } from '@angular/common';
import { RegistrationModule } from 'src/login/registration/registration.module';



@NgModule({
  declarations: [
    AppComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HomeModule,
    RegistrationModule
  ],
  providers: [{ provide: LocationStrategy, useClass: PathLocationStrategy },],
  bootstrap: [AppComponent]
})
export class AppModule { }
