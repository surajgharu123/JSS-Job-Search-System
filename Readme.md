# Job-Search-System



-------------------------------- JSS Project Details -------------------------------------

There are will be Two Microservices:::::::::::::::::::

1. Employee Microservice
2. Jobseeker Microservice
3. User-Management Microservice

Details of Microservices ----------------------------

Employee Services -> PORT NUMBER: 9090
 (i) -> Controller -> Calling API
 (ii) -> DTO -> Java Objects
 (iii) -> Repo -> DB Talk 
 (iv) -> Service -> Main Business Logic Build
 (v) -> Entity -> Creating Table 
 (vi) -> Exception -> Exception Handle
 (vii) -> Security
 (viii) -> Swagger
 (Ix) -> actuator
 (x) -> Testing Mockito Framework and (Rest API)
 
Jobseeker Services -> PORT NUMBER: 9080
 (i) -> Controller -> Calling API
 (ii) -> DTO -> Java Objects
 (iii) -> Repo -> DB Talk 
 (iv) -> Service -> Main Business Logic Build
 (v) -> Entity -> Creating Table 
 (vi) -> Exception -> Exception Handle
 (vii) -> Security
 (viii) -> Swagger
 (Ix) -> actuator
 (x) -> Testing Mockito Framework and (Rest API)
 
 User-Management Services -> PORT NUMBER: 9090
 (i) -> Controller -> Calling API
 (ii) -> DTO -> Java Objects
 (iii) -> Repo -> DB Talk 
 (iv) -> Service -> Main Business Logic Build
 (v) -> Entity -> Creating Table 
 (vi) -> Exception -> Exception Handle
 (vii) -> Security
 (viii) -> Swagger
 (Ix) -> actuator
 (x) -> Testing Mockito Framework and (Rest API)
 
 
 -------------------------- CLIENT-> (API GATEWAY -> Eureka Server -> MICROSERVICES ASSIGNED BY NAME) (Server Side) --------------------------
 
 THERE ARE TOTAL 23 ENDPOINTS. 
 
------------------------- ENDPOINTS PRIORITY LEVEL DIVISON --------------------------------------

PRIORITY P1 --- 
Employee: 1, 2, 3, 4, 5 , 7 , 9 

JOB SEEKER: 1, 2, 3, 4, 5, 6 

PRIORITY P2 ---

Employee: 6, 8, 10, 11 

JOB SEEKER: 7, 8, 9, 10, 11, 12  

------------------------------------------------ Team member specific endpoints information --------------------------------------

Rutuja->  

  

----- Employee----- 

               1. Register Employer (Organization Name, Address, ContactNo, Email etc ) (Post) 

               2. Login Employer (Username & Password) (Post) 

               3. Post a job Job (Job Title, Location, Description, Experience, Salary, Notice  

                  Period, ContactEmail, Status etc) (Post) 

  

  

Samuel ->  

  

------ Employee -------- 

   

               4. Edit Job Job (Job Title, Location, Description, Experience, Salary, Notice  

                  Period, ContactEmail, Status etc.) (Update) 

               5. Delete Job Job (Job ID) (Delete) 

  

  

Shubham ->  

  

----- Employee -------- 

  

               7. Search job seekers by skill set JobSeeker (JobSeeker’s Name, Address, ContactNo,  

               Email , Skill Set etc) (Get With Critieria API) 

  

------ JobSeeker -------- 

  

               6. Apply for a job Job (Job Title, Location, Description, Experience, Salary, Notice  

                  Period, ContactEmail, Status etc) (Post) 

  

  

  

Prashant -> 

  

----- Employee -------  

  

               9. Search JobSeekers by JobID Job (Job Title, Location, Description, Experience, Salary, Notice  

                  Period, ContactEmail, Status etc.) (Criteria API) 

                

----- JobSeeker ------ 

  

               1. Register JobSeeker (JobSeeker’s Name, Address, ContactNo, Email, Skill Set etc.) (Post) 

               2. Login JobSeeker ( UserName & Password) (Post) 

  

  

Suraj -> 

  

------ JobSeeker ------ 

  

               3. Search for a Job by Skills, Designation, Company Job (Job Title, Location, Description,  

                  Experience, Salary, Notice Period, ContactEmail, Status etc.) (Get With Criteria API) 

               4. Search Job by Location Job (Job Title, Location, Description, Experience, Salary, Notice-  

                  Period, ContactEmail, Status etc.) (Get With Criteria API) 

               5. Get specific Job Details Job (Job Title, Location, Description, Experience, Salary, Notice  

                  Period, ContactEmail, Status etc) (Get with Criteria API) 
                  
                  
                  
------------------------------------- List down all Angular components ----------------------------------------------------------

----------- Employee ->  

  

1. Registration Component (Employee) 

2. Login Component (Employee) 

3. Home Component (Jobseeker -> (Apply button initially disable, After Login Jobseeker (Apply button will enable), Employee ->  

(Post button initially disable, After Login Jobseeker (Post button will enable))  

4. Profile Component (Employee) 

5. Created Jobs (Employee)  

6. Header Component 

7. Footer Component 

---------- Jobseeker ->  

  

1. Registration Component (For Jobseeker) 

2. Login Component (For Jobseeker) 

3. Home Component (Jobseeker -> (Apply button initially disable, After Login Jobseeker (Apply button will enable), Employee ->  

(Post button initially disable, After Login Employee (Post button will enable))  

4. Profile Component (For Jobseeker) 

5. Specific Job  

6. Header Component 

7. Footer Component 


-------------------- For More Detaials Please Open a file Link given below --------------------

With Full UI Flow :  https://github.com/surajgharu123/Job-Search-System/blob/main/Full%20JSS%20Project%20informatin.pdf
