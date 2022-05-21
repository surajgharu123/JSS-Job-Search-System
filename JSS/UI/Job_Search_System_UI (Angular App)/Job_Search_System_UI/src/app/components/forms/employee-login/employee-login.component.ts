import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { JobSeeker } from 'src/app/Entity/jobSeekerEntity.entity';

import { JobSeekerService } from 'src/app/service/jobSeekerService.service';

@Component({
  selector: 'app-employee-login',
  templateUrl: './employee-login.component.html',
  styleUrls: ['./employee-login.component.css']
})
export class EmployeeLoginComponent {


          

  // jobSeekerForm = new FormGroup({
  //   username : new FormControl("Suraj1234",[Validators.required,Validators.minLength(3)]),
  //   password : new FormControl("suraj@1234",[Validators.required, Validators.minLength(3)])
  // })

  // checkLoginCredentails() {

  //   let jobSeekerObject = new JobSeeker();
  //   jobSeekerObject.username = this.jobSeekerForm.value['username'];
  //   jobSeekerObject.password = this.jobSeekerForm.value['password'];

  //   console.log(jobSeekerObject);


}
