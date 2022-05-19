package com.jss.employee.service;

import java.util.List;

import com.jss.employee.dto.JobSeeker;

public interface JobSeekerService {
	


	public List<JobSeeker> filterJobSeekerBySkills(String skillSet,String authToken);

}
