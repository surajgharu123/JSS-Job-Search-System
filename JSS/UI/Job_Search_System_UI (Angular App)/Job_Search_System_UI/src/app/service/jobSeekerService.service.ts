import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { JobSeeker } from "../Entity/jobSeekerEntity.entity";

@Injectable()
export class JobSeekerService {


    REST_API_USER= "http://localhost:5300/jss/user/";
    REST_API = "http://localhost:5302/jss/jobseeker/";

    AUTH_TOKEN = "Bearer ";
    constructor(private httpClient: HttpClient) {
        
    }

    getData(): Observable<any> {
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/xml'
            })
        }
        return this.httpClient.get<any>("http://localhost:5302/jss/jobseeker/", httpOptions);
    }

    authentication(jobseeker: JobSeeker): Observable<any> {
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            })


        }

        return this.httpClient.post<any>(this.REST_API_USER + "job/authenticate", JSON.stringify(jobseeker), httpOptions);

    }


    getDataBySearchFlied = (searchCompany:string, searchSkill:string, searchDegi:string) : Observable<any> => {
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
            }),

            

        }
        let paramsT = new HttpParams()
            .set('company' , searchCompany)
            .set('skills', searchSkill)
            .set('designation', searchDegi)

        return this.httpClient.get<any>(this.REST_API + "search",{params:paramsT});

    }

}