import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { JobSeeker } from "../Entity/jobSeekerEntity.entity";

@Injectable()
export class JobSeekerService {


    REST_API_USER= "http://localhost:5300/jss/user/";
    REST_API = "http://localhost:5302/jss/jobseeker/";
    JOBSEEKER_LOGIN = false;
    AUTH_TOKEN = "Bearer ";
    jobData = [];
    SPECIFIC_DATA:Array<any> = new Array();
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
    jobseekerRegister(jobseeker:any): Observable<any>{
        let httpOptions={
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            })
        };
        return this.httpClient.post<any>('http://localhost:5300/jss/user/job/register', JSON.stringify(jobseeker), httpOptions);
    }


    filterJobDataByLoaction(searchByLocation:string) : Observable<any> {

        let paramByLocation = new HttpParams().set('location', searchByLocation);
        return this.httpClient.get<any>(this.REST_API+"searchLocation" , {params : paramByLocation});
    }


    applyForJob(jobDetails:any) : Observable<any> {

        let httpOptions = {
            headers : new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                "Authorization" : this.AUTH_TOKEN
            })
        }

       return this.httpClient.post<any>(this.REST_API+"apply/job",jobDetails,httpOptions);
    }

    getSpecificJobDetails(id:number) : Observable<any> {

        let httpOptions = {
            headers : new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                "Authorization" : this.AUTH_TOKEN
            })
        }

        return this.httpClient.get<any>(this.REST_API+id,httpOptions);
    }

}