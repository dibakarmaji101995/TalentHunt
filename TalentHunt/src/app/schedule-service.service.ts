import { Injectable } from '@angular/core';
import { Schedule } from './Models/schedule';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ScheduleServiceService {
  constructor(private http:HttpClient) { }
  baseUrl: string ='http://localhost:4242/TALENTHUNT';

  selectedSchedule: Schedule = {
      scheduleId:null,
      candidateName: '',
      email:'',
      cctc: null,
      ectc: null,
      gender:'',
      currentOrg:'',
     scheDate:'',
     totalExperience:null,
     noticePeriod:null,
     stack:'',
     releventExp:null,
     location:'',
     contactNumber:null,
     readyToRelocate:'',
    interviewPanel:'' 
  } 
  schedule: Schedule[];

  headers = new HttpHeaders({
    "Content-Type": "application/json"
    
})
  //get data
  getData() {
    return this.http.get(this.baseUrl+'/schedule/getAll');
  }
  //post data
  postData(data) {
    return this.http.post(this.baseUrl+'/schedule/saveSchedule', data,{ headers: this.headers});
  }
  // putdata
  putData(oneSchedule: Schedule) {
    alert(oneSchedule);
    return this.http.put(this.baseUrl+`/schedule/updateSchedule/${this.selectedSchedule.scheduleId}`, oneSchedule);
  }

   // delete data
   deleteData(_id) {
    return this.http.delete(this.baseUrl+`/schedule/deleteSchedule/${_id}`);
  }
}
