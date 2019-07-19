import { HomeComponent } from './home/home.component';
import { HeadComponent } from './head/head.component';
import { AddRequirementComponent } from './add-requirement/add-requirement.component';
import { ScheduleInterviewComponent } from './schedule-interview/schedule-interview.component';
import { ViewRequirementComponent } from './view-requirement/view-requirement.component';
import { ViewScheduleComponent } from './view-schedule/view-schedule.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path: '' , component: HomeComponent},
  {path: 'head' , component: HeadComponent},
  {path: 'requirement' , component: AddRequirementComponent},
  {path: 'scheduleInterview' , component: ScheduleInterviewComponent},
  {path: 'viewRequirement' , component: ViewRequirementComponent},
  {path: 'viewSchedule' , component: ViewScheduleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
