import { Component } from '@angular/core';
import { Router, NavigationStart } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Job_Search_System_UI';

  showHead: boolean = false;

  constructor(private router: Router) {
    // on route change to '/login', set the variable showHead to false
    router.events.forEach((event) => {
      if (event instanceof NavigationStart) {
        if (event['url'] == '/login') {
          this.showHead = false;
        } else if (event['url'] == '/sign-up') {
          this.showHead = false;
        }
        else if(event['url'] == '/emp-login'){
          this.showHead = false;
        }
        else if(event['url'] == '/emp-sign'){
          this.showHead = false;
        }
        else if(event['url'] =='/jobseeker-home') {
          this.showHead = false;
        }
        else if(event['url'] == '/employee-home'){
          this.showHead = false;
        }
        else if(event['url'] == '/post-a-job') {
          this.showHead = false;
        }
        else if(event['url'] == '/specific-job-details') {
          this.showHead  = false;
        }
         else {
          this.showHead = true;
        }

      }
    });
  }
}
