import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Job } from 'src/app/Entity/jobEntity.Entity';
import { JobSeekerService } from 'src/app/service/jobSeekerService.service';
import { JobService } from 'src/app/service/jobService.service';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css'],
  inputs: ['jobSeekerLoggedIn', 'employeeLoggedIn', 'filteredListData']
})
export class JobsComponent implements OnInit {

  jobSeekerLoggedIn: boolean = false;
  employeeLoggedIn: boolean = false;

  filteredListData: Array<Job> = new Array();
  appliedJobsListData: Array<Job> = new Array();
  isApplied:string = "Apply"; 
  constructor(private jobService: JobService, private jobSeekerService:JobSeekerService, private route: Router) {
    this.jobService.getData().subscribe((serverResponse) => {
      this.jobService.jobsData = serverResponse;

      console.log(serverResponse);
      this.filteredListData = serverResponse;
      this.isApplied = "Applied";
    })
  }

  ngOnInit(): void {

  }


  applyForAJob(job:any, buttonApply:any) {

    this.jobSeekerService.applyForJob(job).subscribe((serverResponse) => {
         
         
         alert("You Applied For Job SuccessFully");
         buttonApply = "Applied";
    }, (error) => {
      alert("You have not full fill cretia of job so you can't apply for this job");
    })
    
  }



  showDetails(job:any) {
    //console.log("the id value is ", job['id']);
    this.jobSeekerService.getSpecificJobDetails( job['id']).subscribe((responseData) => {
     
      this.jobSeekerService.SPECIFIC_DATA[0] = responseData;
      this.route.navigate(['/specific-job-details']);
    },(error)=> {
      alert("Sorry, Facing Some issues");
    })
  }




}
