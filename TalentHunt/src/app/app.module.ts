

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddRequirementComponent } from './add-requirement/add-requirement.component';
import { HomeComponent } from './home/home.component';
import { HeadComponent } from './head/head.component';
import { ViewRequirementComponent } from './view-requirement/view-requirement.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ScheduleInterviewComponent } from './schedule-interview/schedule-interview.component';
import { ViewScheduleComponent } from './view-schedule/view-schedule.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RequirementServiceService } from './requirement-service.service';
import { HttpClientModule } from '@angular/common/http'; 

@NgModule({
  declarations: [
    AppComponent,
    AddRequirementComponent,
    HomeComponent,
    HeadComponent,
    ViewRequirementComponent,
    ScheduleInterviewComponent,
    ViewScheduleComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [RequirementServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
