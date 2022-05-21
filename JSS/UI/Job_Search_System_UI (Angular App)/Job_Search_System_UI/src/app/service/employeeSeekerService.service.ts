import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../Entity/employeeEntity.entity";


@Injectable()
export class EmployeeSeekerService {


    constructor(private httpClient: HttpClient) {

    }

    REST_API = "http://localhost:5300/jss/user/";
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
}