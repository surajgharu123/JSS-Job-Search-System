import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { JobSeeker } from "../Entity/jobSeekerEntity.entity";

@Injectable()
export class JobSeekerService{


    REST_API = "http://localhost:5300/jss/user/";

    AUTH_TOKEN = "Bearer ";
    constructor(private httpClient : HttpClient) {
       console.log("bole to chelega ki ni...");
    }

    // getData() :Observable<any> {
    //     return "hello";
    // }

    authentication(jobseeker:JobSeeker) : Observable<any> {
        let httpOptions = {
            headers : new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type' : 'application/json'
            })

           
        }

        return this.httpClient.post<any>(this.REST_API + "job/authenticate", JSON.stringify(jobseeker), httpOptions);

    }

}