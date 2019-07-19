import { Component, OnInit, OnChanges } from '@angular/core';
import { RequirementServiceService } from '../requirement-service.service';
import {NgForm} from '@angular/forms';
import { Requirement } from '../Models/requirement';

@Component({
  selector: 'app-add-requirement',
  templateUrl: './add-requirement.component.html',
  styleUrls: ['./add-requirement.component.css']
})
export class AddRequirementComponent implements OnInit,OnChanges {
  

  constructor(private requiService: RequirementServiceService) { }
   
  successMsg : boolean = false;
  Message : string = "Suucessfully saved"


   // reset form
  resetForm(form ?: NgForm) {
    if (form) {
   // alert("Rest Form");
      form.reset();
    }
  }

  //get data
  getRequirement() {
    this.requiService.getData().subscribe(res => {
      this.requiService.requirement = res as Requirement[];
    });
  }
  
  // post data
  addRequirement(form: NgForm) {
    this.successMsg = true;
    const oneRequirement = form.value;
    this.requiService.postData(oneRequirement).subscribe(res => {

      console.log(res);
      this.resetForm(form);
      this.getRequirement(); 
  
    });
  }

  ngOnInit() {
    this.getRequirement();
  }

  ngOnChanges(){
    this.successMsg = null;
  }
}
