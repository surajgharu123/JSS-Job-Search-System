import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/Entity/jobEntity.Entity';
import { JobSeeker } from 'src/app/Entity/jobSeekerEntity.entity';
import { EmployeeSeekerService } from 'src/app/service/employeeSeekerService.service';
import { JobSeekerService } from 'src/app/service/jobSeekerService.service';
import { JobService } from 'src/app/service/jobService.service';

@Component({
  selector: 'app-employee-home-page',
  templateUrl: './employee-home-page.component.html',
  styleUrls: ['./employee-home-page.component.css']
})
export class EmployeeHomePageComponent implements OnInit {



  idNumber:boolean=false; 
  anyVar:Array<Job> = new Array();
  isEmployeeLoggedIn: boolean = true;
  filteredData:Array<JobSeeker> = new Array();
  constructor(private employeeSeekerService: EmployeeSeekerService, private jobService: JobService, 
    private jobSeekerService:JobSeekerService) {
      this.employeeSeekerService.getAllJobSeekerDeatils().subscribe((responseData)=> {
        this.filteredData = responseData;
        console.log("The Auth token :" , this.jobSeekerService.AUTH_TOKEN, " " , responseData);
      })
   }

  getFilteredData(searchSkillSet: string) {

   // console.log(searchCompany, " : ", searchSkill, " : ", searchDegi, " : ");

    this.employeeSeekerService.filterJobSeekerBySkillSet(searchSkillSet).subscribe((serverResponse) => {
      console.log(serverResponse);
      this.jobService.jobsData = serverResponse;
      this.filteredData = serverResponse;
    }, (error) => {
      alert("Entered Username & Password is not valid");
    })
  } 
  searchByJobId(id : any){
    let ID:number=id;
    this.employeeSeekerService.searchJobById(ID).subscribe((serverResponse) => {
      console.log(serverResponse);
      this.jobService.jobsData = serverResponse;
      this.anyVar = serverResponse;
      this.idNumber=true;
    }, (error) => {
      alert("Entered ID is not valid");
    })
  }  
  ngOnInit(): void {
  }

}
