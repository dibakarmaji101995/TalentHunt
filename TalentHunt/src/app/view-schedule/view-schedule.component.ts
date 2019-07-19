import { Component, OnInit } from '@angular/core';
import { ScheduleServiceService } from '../schedule-service.service';
import { NgForm } from '@angular/forms';
import { Schedule } from '../Models/schedule';

@Component({
  selector: 'app-view-schedule',
  templateUrl: './view-schedule.component.html',
  styleUrls: ['./view-schedule.component.css']
})
export class ViewScheduleComponent implements OnInit {
  constructor(private scheduleService: ScheduleServiceService) { }
  updateMsg : boolean = false;
  upMsg : string = "";
  deleteMsg : boolean = false;
  delMsg : string = "";
  
  // reset form
  resetForm(form ?: NgForm) {
    if (form) {
   //   alert("Rest Form");
      form.reset();
    }
  }
  //get data
  getSchedule() {
    this.scheduleService.getData().subscribe(res => {
      this.scheduleService.schedule = res as Schedule[];
    });
  }
  
  // put data
  updateSchedule(form: NgForm) {
    this.updateMsg=true;
    this.deleteMsg=false;
    const oneReq = form.value;
    if (oneReq.requirementId!=0) {
      this.scheduleService.putData(oneReq).subscribe(res => {
        console.log(res);
        this.getSchedule();
        this.resetForm(form);
        this.upMsg="Successfully updated";
      });
    }
  }

   // edit Data
   editSchedule(schedule) {
       console.log(schedule);
     this.scheduleService.selectedSchedule = schedule;
   }

   // remove data
   removeSchedule(id) {
     this.deleteMsg=true;
     this.updateMsg=false;
    this.scheduleService.deleteData(id).subscribe(() => {
      this.getSchedule();
      this.delMsg="Successfully deleted";
    });
  }
 ngOnInit() {
  this.getSchedule();
  }

  ngOnChanges() {
  this.deleteMsg = null;
  this.updateMsg = null;
  }
}
