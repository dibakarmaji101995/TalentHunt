import { Component, OnInit } from '@angular/core';
import { ScheduleServiceService } from '../schedule-service.service';
import { NgForm } from '@angular/forms';
import { Schedule } from '../Models/schedule';

@Component({
  selector: 'app-schedule-interview',
  templateUrl: './schedule-interview.component.html',
  styleUrls: ['./schedule-interview.component.css']
})
export class ScheduleInterviewComponent implements OnInit {
  constructor(private scheduleService: ScheduleServiceService) { }
   
  successMsg : boolean = false;
  Message : string = "";


   // reset form
  resetForm(form ?: NgForm) {
    if (form) {
   // alert("Rest Form");
      form.reset();
    }
  }

  //get data
  getSchedule() {
    this.scheduleService.getData().subscribe(res => {
      this.scheduleService.schedule = res as Schedule[];
    });
  }
  
  // post data
  addSchedule(form: NgForm) {
    this.successMsg = true;
    const oneRequirement = form.value;
    this.scheduleService.postData(oneRequirement).subscribe(res => {
      this.Message="Suucessfully saved";
      console.log(res);
      this.resetForm(form);
      this.getSchedule(); 
  
    });
  }

  ngOnInit() {
    this.getSchedule();
  }

  ngOnChanges(){
    this.successMsg = null;
  }
}
