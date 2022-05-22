import { Component, OnInit } from '@angular/core';
import { JobSeekerService } from 'src/app/service/jobSeekerService.service';

@Component({
  selector: 'app-job-lists',
  templateUrl: './job-lists.component.html',
  styleUrls: ['./job-lists.component.css']
})
export class JobListsComponent implements OnInit {

  //JobDetails:Array<any> = new Array();
  objectKeys = Object.keys;
  constructor(public jobSeekerService:JobSeekerService) {
    //this.JobDetails = this.jobSeekerService.SPECIFIC_DATA;
    //console.log(this.JobDetails);

  // console.log(this.jobSeekerService.SPECIFIC_DATA[0].jobTitle);
  }
  ngOnInit(): void {
    
  }

}
