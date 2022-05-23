import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeSeekerService } from 'src/app/service/employeeSeekerService.service';

@Component({
  selector: 'app-jobs-creation',
  templateUrl: './jobs-creation.component.html',
  styleUrls: ['./jobs-creation.component.css']
})
export class JobsCreationComponent  {

  postjobForm = new FormGroup({
    jobTitle : new FormControl(null, [Validators.required, Validators.minLength(3)]),
    location : new FormControl(null, [Validators.required, Validators.minLength(3),Validators.maxLength(12)]),
    description : new FormControl(null, [Validators.required, Validators.minLength(5),Validators.maxLength(50)]),
    experience : new FormControl(null,[Validators.required]),
    status:new FormControl(null,[Validators.required]),
    skills:new FormControl(null,[Validators.required,Validators.minLength(1)]),
    salary : new FormControl(null, [Validators.required,Validators.minLength(4)]),
    noticePeriod : new FormControl(null,[Validators.required]),
    contactEmail: new FormControl(null, [Validators.required,Validators.minLength(4)]),
    companyName : new FormControl(null, [Validators.required,Validators.minLength(4)])

  })
  job:any =[];
  constructor(private employeeService: EmployeeSeekerService, private route:Router){

  }
  submitJobDetails = () => {
    let new_job = {
      jobTitle: this.postjobForm.value.jobTitle,
      location: this.postjobForm.value.location,
      description: this.postjobForm.value.description,
      experience: this.postjobForm.value.experience,
      salary: this.postjobForm.value.salary,
      noticePeriod: this.postjobForm.value.noticePeriod,
      contactEmail : this.postjobForm.value.contactEmail,
      status : this.postjobForm.value.status,
      skills : this.postjobForm.value.skills,
      companyName : this.postjobForm.value.companyName

      };
      this.employeeService.postAJob(new_job).subscribe((serverResponse)=>{
          console.log('posted job Details - serviceResponse :',serverResponse);
          this.job.push(serverResponse);
          this.route.navigate(['/employee-home']);
      })

   console.log(this.postjobForm.value);
    }
}