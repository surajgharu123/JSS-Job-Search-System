package com.jss.employee.service;

import java.util.List;

import com.jss.employee.dto.Job;

public interface JobService {

	List<Job> searchByJobId(Integer id);
	public Boolean deleteJobById(int id);
	
}
