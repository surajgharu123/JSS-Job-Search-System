import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JobseekerLoginComponent } from './components/forms/jobseeker-login/jobseeker-login.component';
import { EmployeeLoginComponent } from './components/forms/employee-login/employee-login.component';
import { HomeComponent } from './components/views/home/home.component';
import { EmployeeRegistrationComponent } from './components/forms/employee-registration/employee-registration.component';
import { LoginComponent } from './components/views/login/login.component';
import { JobseekerRegistrationComponent } from './components/forms/jobseeker-registration/jobseekerregistration.component';
import { JobseekerHomePageComponent } from './components/forms/jobseeker-home-page/jobseeker-home-page.component';
import { EmployeeHomePageComponent } from './components/forms/employee-home-page/employee-home-page.component';
import { JobsCreationComponent } from './components/forms/jobs-creation/jobs-creation.component';
import { JobListsComponent } from './components/tables/job-list/job-lists.component';
const routes: Routes = [
         {path:'home', component:HomeComponent},
         {path: 'login', component:JobseekerLoginComponent},
         {path:'sign-up', component:JobseekerRegistrationComponent},
         {path:'emp-login', component:EmployeeLoginComponent},
         {path:'emp-sign', component:EmployeeRegistrationComponent},
         {path:'jobseeker-home', component:JobseekerHomePageComponent},
         {path:'employee-home', component:EmployeeHomePageComponent},
         {path:'post-a-job',component:JobsCreationComponent},
         {path:'specific-job-details', component:JobListsComponent}
         
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
