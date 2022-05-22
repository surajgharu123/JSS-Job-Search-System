import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/Entity/jobEntity.Entity';
import { JobService } from 'src/app/service/jobService.service';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {

  jobList:Array<Job> = new Array<Job>();
  constructor(private jobService : JobService) { 
    this.jobService.getData().subscribe((serverResponse)=> {
      this.jobService.jobsData = serverResponse;
      this.jobList = this.jobService.jobsData;
    })
  }

  ngOnInit(): void {
  }




}
