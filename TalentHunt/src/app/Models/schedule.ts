export class Schedule {

    constructor(
                public scheduleId:number,
                public candidateName: string,
                public email:string,
                public cctc: number,
                public ectc: number,
                public gender:string,
                public currentOrg:string,
                public  scheDate:string,
                public  totalExperience:number,
                public  noticePeriod:number,
                public  stack:string,
                public  releventExp:number,
                public  location:string,
                public  contactNumber:number,
                public  readyToRelocate:string,
                public interviewPanel:string ) {}
}