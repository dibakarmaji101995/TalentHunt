export class Requirement {

    constructor(
                public requirementId:number,
                public clientName: string,
                public noOfPosition:number,
                public stack: string,
                public desg: string,
                public expRequired: string,
                public jobDesc: string,
                public location: string,
                public closingDate: string  ) {}
}