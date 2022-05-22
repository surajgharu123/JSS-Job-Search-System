import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Employee } from 'src/app/Entity/employeeEntity.entity';

import { EmployeeSeekerService } from 'src/app/service/employeeSeekerService.service';

@Component({
  selector: 'app-employee-login',
  templateUrl: './employee-login.component.html',
  styleUrls: ['./employee-login.component.css']
})
export class EmployeeLoginComponent implements OnInit {

  constructor(private employeeSeekerService : EmployeeSeekerService, private router : Router) { }

  ngOnInit(): void {
  }

  employeeLoginForm = new FormGroup({
    username : new FormControl("rutuja",[Validators.required,Validators.minLength(3)]),
    password : new FormControl("shubhum@123",[Validators.required, Validators.minLength(3)])
  })


  checkLoginCredentails() {

    let employeeSeekerObject = new Employee();
    employeeSeekerObject.userName = this.employeeLoginForm.value['username'];
    employeeSeekerObject.password = this.employeeLoginForm.value['password'];

    this.employeeSeekerService.authentication(employeeSeekerObject).subscribe((responseData) => {
      this.employeeSeekerService.AUTH_TOKEN += responseData['jwt'];
      console.log(this.employeeSeekerService.AUTH_TOKEN);
      if(this.employeeSeekerService.AUTH_TOKEN.length > 12) {
        this.router.navigate(['/post-a-job']);
        console.log("Hello Guys ", this.employeeSeekerService.AUTH_TOKEN.length);
    }

    else {
      alert("Invalid Username & Password Entered by you");
    }

    })
    console.log(this.employeeLoginForm.value);

    

  }

}
