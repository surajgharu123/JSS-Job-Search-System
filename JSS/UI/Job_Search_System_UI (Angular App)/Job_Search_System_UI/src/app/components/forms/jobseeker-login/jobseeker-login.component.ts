import { Component} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JobSeeker } from 'src/app/Entity/jobSeekerEntity.entity';

import { JobSeekerService } from 'src/app/service/jobSeekerService.service';

@Component({
  selector: 'app-jobseeker-login',
  templateUrl: './jobseeker-login.component.html',
  styleUrls: ['./jobseeker-login.component.css']
})
export class JobseekerLoginComponent {

  constructor( private jobSeekerService: JobSeekerService, private route : Router) {
    // this.jobSeekerService.getData().subscribe((serverdata) => {
    //   console.log("Server Data : ", serverdata);
    // })
   }


  jobSeekerForm = new FormGroup({
    username : new FormControl("Suraj1234",[Validators.required,Validators.minLength(3)]),
    password : new FormControl("suraj@1234",[Validators.required, Validators.minLength(3)])
  })

  checkLoginCredentails() {

    let jobSeekerObject = new JobSeeker();
    jobSeekerObject.username = this.jobSeekerForm.value['username'];
    jobSeekerObject.password = this.jobSeekerForm.value['password'];

    console.log(jobSeekerObject);

    this.jobSeekerService.authentication(jobSeekerObject).subscribe((responseData)=> {
     this.jobSeekerService.AUTH_TOKEN += responseData['jwt'];
      console.log("Server Resonse Data " , this.jobSeekerService.AUTH_TOKEN);
      if(this.jobSeekerService.AUTH_TOKEN.length >12)
      {
        alert("You Logged In SuccessFully");
        this.route.navigate(['/jobseeker-home']);
        
      }
    }, (error)=> {
      console.log("Server Error" , error);
    })

  }
}
