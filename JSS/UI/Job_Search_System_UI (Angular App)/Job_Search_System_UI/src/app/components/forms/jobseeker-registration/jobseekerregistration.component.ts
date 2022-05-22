import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { JobSeekerService } from 'src/app/service/jobSeekerService.service';

@Component({
  selector: 'app-jobseekerregistration',
  templateUrl: './jobseekerregistration.component.html',
  styleUrls: ['./jobseekerregistration.component.css']
})
export class JobseekerRegistrationComponent  {

  some:any;

  jobSeekerRegisterForm = new FormGroup({
    name : new FormControl(null, [Validators.required, Validators.minLength(3)]),
    username : new FormControl("", [Validators.required, Validators.minLength(3),Validators.maxLength(12)]),
    password : new FormControl(null, [Validators.required, Validators.minLength(3),Validators.maxLength(12)]),
    address : new FormControl(null, [Validators.required,Validators.minLength(3)]),
    contactNo : new FormControl(null, [Validators.required,Validators.maxLength(10),Validators.minLength(10)]),
    email : new FormControl(null, [Validators.required,Validators.minLength(3)]),
    skillset: new FormControl(null, [Validators.required,Validators.minLength(4)]),
    roles : new FormControl(null, [Validators.required])

  })
  jobseeker:any =[];
  constructor ( private jobSeekerServices : JobSeekerService){

  }

  submitJobSeekerDetails = () => {
    let new_jobseeker = {
      name: this.jobSeekerRegisterForm.value.name,
      username: this.jobSeekerRegisterForm.value.username,
      password: this.jobSeekerRegisterForm.value.password,
      address: this.jobSeekerRegisterForm.value.address,
      contactNo: this.jobSeekerRegisterForm.value.contactNo,
      email: this.jobSeekerRegisterForm.value.email,
      skillset : this.jobSeekerRegisterForm.value.skillset,
      roles : this.jobSeekerRegisterForm.value.roles
      };
      this.jobSeekerServices.jobseekerRegister(new_jobseeker).subscribe((serverResponse)=>{
          console.log('jobseekerRegister Details - serviceResponse :',serverResponse);
          this.jobseeker.push(serverResponse);
      })
  
   console.log(this.jobSeekerRegisterForm.value);
    }
}
