package com.jss.employee.service;

import java.util.List;

import com.jss.employee.dto.Employee;
import com.jss.employee.dto.Job;

public interface JobService {


	//List<Job> searchByJobId(Integer id,String authToken);

	List<Job> searchByJobId(Integer id);
	public Boolean deleteJobById(int id);
	Job updateJob(int id, Job job);
	
}
