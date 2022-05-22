import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../Entity/employeeEntity.entity";


@Injectable()
export class EmployeeSeekerService {


    constructor(private httpClient: HttpClient) {

    }

    REST_API = "http://localhost:5300/jss/user/";
    BASE_API = "http://localhost:5301/jss/employee";
    AUTH_TOKEN = "Bearer ";

    authentication(employeeSeekerObject: Employee): Observable<any> {

        let httpOptions = {
            headers : new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type' : 'application/json'
            })

           
        }

        return this.httpClient.post<any>(this.REST_API + "employee/authenticate", JSON.stringify(employeeSeekerObject), httpOptions);
    }

    employeeRegister(employees:any): Observable<any>{
        let httpOptions={
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            })
        };
        return this.httpClient.post<any>(this.REST_API + 'employee/register', JSON.stringify(employees), httpOptions);
    }
    postAJob(job:any):Observable<any>{
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type' : 'application/json',
                'Authorization' : this.AUTH_TOKEN
            })
        }
        return this.httpClient.post<any>("http://localhost:5302/jss/jobseeker/", JSON.stringify(job), httpOptions);

    }
    
    // getDataBySearchFlied = ( searchSkill:string) : Observable<any> => {
    //     let httpOptions = {
    //         headers: new HttpHeaders({
    //             'Access-Control-Allow-Origin': '*',
    //         }),

    //     }
    //     let paramsT = new HttpParams()
    //         .set('skills', searchSkill)

    //     return this.httpClient.get<any>(this.BASE_API + "/search/filtercriteria",{params:paramsT});

    // }

}