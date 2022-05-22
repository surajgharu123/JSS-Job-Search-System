import { Component, OnInit } from '@angular/core';
import { JobSeekerService } from 'src/app/service/jobSeekerService.service';
import { JobService } from 'src/app/service/jobService.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent  {


  constructor(private jobSeekerSerice:JobSeekerService, private jobService: JobService){}
  //searchText:string = '';
  getFilteredData(searchCompany:string, searchSkill:string,searchDegi:string) {

    console.log(searchCompany , " : ",searchSkill , " : ", searchDegi , " : ");

    this.jobSeekerSerice.getDataBySearchFlied(searchCompany, searchSkill , searchDegi).subscribe((serverResponse)=> {
      console.log(serverResponse);
      this.jobService.jobsData = serverResponse;
    })
  }
  

}
