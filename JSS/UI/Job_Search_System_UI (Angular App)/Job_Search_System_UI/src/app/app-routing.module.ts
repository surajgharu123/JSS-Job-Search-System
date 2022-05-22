import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JobseekerLoginComponent } from './components/forms/jobseeker-login/jobseeker-login.component';
import { EmployeeLoginComponent } from './components/forms/employee-login/employee-login.component';
import { HomeComponent } from './components/views/home/home.component';
import { EmployeeRegistrationComponent } from './components/forms/employee-registration/employee-registration.component';
import { LoginComponent } from './components/views/login/login.component';
import { JobseekerRegistrationComponent } from './components/forms/jobseeker-registration/jobseekerregistration.component';
const routes: Routes = [
         {path:'home', component:HomeComponent},
         {path: 'login', component:JobseekerLoginComponent},
         {path:'sign-up', component:JobseekerRegistrationComponent},
         {path:'emp-login', component:EmployeeLoginComponent},
         {path:'emp-sign', component:EmployeeRegistrationComponent}

         
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
