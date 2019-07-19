import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RequirementServiceService } from '../requirement-service.service';
import { Requirement } from '../Models/requirement';

@Component({
  selector: 'app-view-requirement',
  templateUrl: './view-requirement.component.html',
  styleUrls: ['./view-requirement.component.css']
})
export class ViewRequirementComponent implements OnInit {
  constructor(private reqService: RequirementServiceService) { }
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
  getRequirement() {
    this.reqService.getData().subscribe(res => {
      this.reqService.requirement = res as Requirement[];
    });
  }
  
  // put data
  updateRequirement(form: NgForm) {
    this.updateMsg=true;
    this.deleteMsg=false;
    const oneReq = form.value;
   // alert(oneReq);
    if (oneReq.requirementId!=0) {
      this.reqService.putData(oneReq).subscribe(res => {
        console.log(res);
        this.getRequirement();
        this.resetForm(form);
        this.upMsg="Successfully updated";
      });
    }
  }

   // edit Data
   editRequirement(requirement) {
       console.log(requirement);
     this.reqService.selectedRequirement = requirement;
   }

   // remove data
   removeRequirement(id) {
     this.deleteMsg=true;
     this.updateMsg=false;
    this.reqService.deleteData(id).subscribe(() => {
      this.getRequirement();
      this.delMsg="Successfully deleted";
    });
  }
 ngOnInit() {
  this.getRequirement();
  }

  ngOnChanges() {
  this.deleteMsg = null;
  this.updateMsg = null;
  }
}
