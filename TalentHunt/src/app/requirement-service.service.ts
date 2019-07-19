import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Requirement } from './Models/requirement';

@Injectable({
  providedIn: 'root'
})
export class RequirementServiceService {

  constructor(private http:HttpClient) { }
  baseUrl: string ='http://localhost:4242/TALENTHUNT';

  selectedRequirement: Requirement = {
                 requirementId:null,
                 clientName: '',
                 noOfPosition: null,
                 stack: '',
                 desg: '',
                 expRequired: null,
                 jobDesc: '',
                 location: '',
                 closingDate: ''
  } 
  requirement: Requirement[];

  headers = new HttpHeaders({
    "Content-Type": "application/json"
    
})
  //get data
  getData() {
    return this.http.get(this.baseUrl+'/requi/getAll');
  }
  //post data
  postData(data) {
    return this.http.post(this.baseUrl+'/requi/saveRequirement', data,{ headers: this.headers});
  }
  // putdata
  putData(oneRequirement: Requirement) {
    //alert(oneRequirement);
    return this.http.put(this.baseUrl+`/requi/updateRequirement/${this.selectedRequirement.requirementId}`, oneRequirement);
  }

   // delete data
   deleteData(_id) {
    return this.http.delete(this.baseUrl+`/requi/deleteRequirement/${_id}`);
  }
}
