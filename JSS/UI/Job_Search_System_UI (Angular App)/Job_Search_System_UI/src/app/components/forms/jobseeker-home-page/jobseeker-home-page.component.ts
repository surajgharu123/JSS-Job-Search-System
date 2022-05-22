import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/Entity/jobEntity.Entity';
import { JobSeekerService } from 'src/app/service/jobSeekerService.service';
import { JobService } from 'src/app/service/jobService.service';

@Component({
  selector: 'app-jobseeker-home-page',
  templateUrl: './jobseeker-home-page.component.html',
  styleUrls: ['./jobseeker-home-page.component.css'],

})
export class JobseekerHomePageComponent {

  isJobSeekerLoggedIn: boolean = true;
  FilteredJobList: Array<Job> = new Array();
  constructor(private jobSeekerSerice: JobSeekerService, private jobService: JobService) { }

  getFilteredData(searchCompany: string, searchSkill: string, searchDesignation: string) {



    this.jobSeekerSerice.getDataBySearchFlied(searchCompany, searchSkill, searchDesignation).subscribe((serverResponse) => {

      this.jobService.jobsData = serverResponse;

      this.FilteredJobList = serverResponse;
    }, (error) => {
      alert("Entered Job Data is not available");
    })
  }


  searchByLocation(searchLocation: string) {

    this.jobSeekerSerice.filterJobDataByLoaction(searchLocation).subscribe((serverResponse) => {
      this.FilteredJobList = serverResponse;
    }, (error) => {
      alert("OOps Data is not avaiable");
    });
  }

}
