import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './components/views/registration/registration.component';
import { LoginComponent } from './components/views/login/login.component';
import { HomeComponent } from './components/views/home/home.component';
import { ProfileComponent } from './components/views/profile/profile.component';
import { JobsComponent } from './components/views/jobs/jobs.component';
import { CreatingjobsComponent } from './components/views/creatingjobs/creatingjobs.component';
import { JobseekerLoginComponent } from './components/forms/jobseeker-login/jobseeker-login.component';
import { JobregistrationComponent } from './components/forms/jobregistration/jobregistration.component';
import { JobseekerregistrationComponent } from './components/forms/jobseekerregistration/jobseekerregistration.component';
import { LoginRegistrationComponent } from './components/forms/login-registration/login-registration.component';
import { JobsCreationComponent } from './components/forms/jobs-creation/jobs-creation.component';
import { EmployeeLoginComponent } from './components/forms/employee-login/employee-login.component';
import { EmployeeRegistrationComponent } from './components/forms/employee-registration/employee-registration.component';
import { CreatedJobByEmployeeComponent } from './components/forms/created-job-by-employee/created-job-by-employee.component';
import { JobListsComponent } from './components/tables/job-lists/job-lists.component';
import { JobseekerListComponent } from './components/tables/jobseeker-list/jobseeker-list.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    HomeComponent,
    ProfileComponent,
    JobsComponent,
    CreatingjobsComponent,
    JobseekerLoginComponent,
    JobregistrationComponent,
    JobseekerregistrationComponent,
    LoginRegistrationComponent,
    JobsCreationComponent,
    EmployeeLoginComponent,
    EmployeeRegistrationComponent,
    CreatedJobByEmployeeComponent,
    JobListsComponent,
    JobseekerListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
