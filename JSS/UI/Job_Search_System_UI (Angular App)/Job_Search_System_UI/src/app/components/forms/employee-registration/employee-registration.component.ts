import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { EmployeeSeekerService } from 'src/app/service/employeeSeekerService.service';

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent {

  employeeRegisterForm = new FormGroup({
    userName : new FormControl(null, [Validators.required, Validators.minLength(3),Validators.maxLength(12)]),
    password : new FormControl(null, [Validators.required, Validators.minLength(6),Validators.maxLength(12)]),
    orgnizationName : new FormControl(null, [Validators.required,Validators.minLength(4)]),
    role : new FormControl(null, [Validators.required]),
    location:new FormControl(null, [Validators.required,Validators.minLength(3)]),
    email: new FormControl(null, [Validators.required]),
    description :new FormControl(null, [Validators.required]),
    contact: new FormControl(null, [Validators.required,Validators.maxLength(10),Validators.minLength(10)]),
    address : new FormControl(null, [Validators.required,Validators.minLength(3)])

  })
  employees:any =[];
  constructor ( private employeeServices : EmployeeSeekerService,private router : Router){

  }

  submitEmployeeDetails = () => {
    let new_employee = {
      userName: this.employeeRegisterForm.value.userName,
      password: this.employeeRegisterForm.value.password,
      orgnizationName: this.employeeRegisterForm.value.orgnizationName,
      role : this.employeeRegisterForm.value.role,
      location: this.employeeRegisterForm.value.location,
      email: this.employeeRegisterForm.value.email,
      contact : this.employeeRegisterForm.value.contact,
      address : this.employeeRegisterForm.value.address,
      description : this.employeeRegisterForm.value.description
      };
      this.employeeServices.employeeRegister(new_employee).subscribe((serverResponse)=>{
          console.log('employeeRegister Details - serviceResponse :',serverResponse);
          this.employees.push(serverResponse);
          this.router.navigate(['/emp-login']);
      })
  
   console.log(this.employeeRegisterForm.value);
    }
}

