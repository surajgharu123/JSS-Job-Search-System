import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";


@Injectable()
export class JobService{


    jobsData = [];
    REST_API = "http://localhost:5300/jss/user/";
    constructor(private httpClient: HttpClient){}


    getData(): Observable<any> {
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*'
            })
        }
        return this.httpClient.get<any>("http://localhost:5302/jss/jobseeker/", httpOptions);
    }


    

    

}