import { Component} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-jobseeker-login',
  templateUrl: './jobseeker-login.component.html',
  styleUrls: ['./jobseeker-login.component.css']
})
export class JobseekerLoginComponent {

  constructor() { }


  jobSeekerForm = new FormGroup({
    username : new FormControl("Username",[Validators.required,Validators.minLength(3)]),
    password : new FormControl("Password",[Validators.required, Validators.minLength(3)])
  })

  checkLoginCredentails() {
    console.log(this.jobSeekerForm.value);
  }
}