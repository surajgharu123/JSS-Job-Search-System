import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeLoginComponent } from './components/forms/employee-login/employee-login.component';
import { HomeComponent } from './components/views/home/home.component';
import { EmployeeRegistrationComponent } from './components/forms/employee-registration/employee-registration.component';
import { LoginComponent } from './components/views/login/login.component';
import { JobseekerRegistrationComponent } from './components/forms/jobseeker-registration/jobseekerregistration.component';
const routes: Routes = [
         {path: 'login', component:LoginComponent},
         {path:'sign-up', component:JobseekerRegistrationComponent},
         
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
