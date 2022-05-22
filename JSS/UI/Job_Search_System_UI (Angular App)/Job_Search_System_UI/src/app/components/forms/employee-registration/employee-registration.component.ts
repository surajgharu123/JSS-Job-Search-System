import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { EmployeeSeekerService } from 'src/app/service/employeeSeekerService.service';

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent {

  // this.parentRouter = Routerthis.parentRouter.navigateByUrl('/login');
  employeeRegisterForm = new FormGroup({
    userName: new FormControl("Jerry", [Validators.required, Validators.minLength(3), Validators.maxLength(12)]),
    password: new FormControl("12345678", [Validators.required, Validators.minLength(6), Validators.maxLength(12)]),
    orgnizationName: new FormControl("Aensar", [Validators.required, Validators.minLength(4)]),
    role: new FormControl(null, [Validators.required]),
    location: new FormControl("Pune", [Validators.required, Validators.minLength(3)]),
    email: new FormControl("zerry123@gmail.com", [Validators.required]),
    description: new FormControl("Working in a Peacefull Environment", [Validators.required]),
    contact: new FormControl(9875256756, [Validators.required, Validators.maxLength(10), Validators.minLength(10)]),
    address: new FormControl("VPO Dharamkot, Punjab", [Validators.required, Validators.minLength(3)])

  })
  employees: any = [];
  constructor(private employeeServices: EmployeeSeekerService) { }



  submitEmployeeDetails() {
    let new_employee = {
      userName: this.employeeRegisterForm.value['userName'],
      password: this.employeeRegisterForm.value['password'],
      orgnizationName: this.employeeRegisterForm.value['orgnizationName'],
      role: this.employeeRegisterForm.value['role'],
      location: this.employeeRegisterForm.value['location'],
      email: this.employeeRegisterForm.value['email'],
      contact: this.employeeRegisterForm.value['contact'],
      address: this.employeeRegisterForm.value['address'],
      description: this.employeeRegisterForm.value['description']
    };
    this.employeeServices.employeeRegister(new_employee).subscribe((serverResponse) => {
      console.log('employeeRegister Details - serviceResponse :', serverResponse);
      this.employees.push(serverResponse);
    })

    console.log("The value is here ", this.employeeRegisterForm.value);
    
  }
}

