import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/Entity/jobEntity.Entity';
import { JobSeekerService } from 'src/app/service/jobSeekerService.service';
import { JobService } from 'src/app/service/jobService.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent  {


  
  constructor(private jobSeekerSerice:JobSeekerService, private jobService: JobService){}
  
  jobFilteredList:Array<Job> = new Array();
  getFilteredData(searchCompany:string, searchSkill:string,searchDesignation:string) {

    

    this.jobSeekerSerice.getDataBySearchFlied(searchCompany, searchSkill , searchDesignation).subscribe((serverResponse)=> {
     
      this.jobService.jobsData = serverResponse;

      this.jobFilteredList = serverResponse;
    }, (error) => {
      alert("Entered Job Data is not available");
    })
  }


  searchByLocation(searchLocation:string) {

    this.jobSeekerSerice.filterJobDataByLoaction(searchLocation).subscribe((serverResponse)=> {
      this.jobFilteredList = serverResponse;
    }, (error) => {
      alert("OOps Data is not avaiable");
    });
  }
  

}
