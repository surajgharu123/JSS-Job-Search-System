package com.jss.jobseeker.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.jss.jobseeker.dto.JobDTO;


public interface JobSeekerService {
	
	public List<JobDTO> SearchByFilterCriteria(String company, String skills, String designation);
	
	public List<JobDTO> getAllRecords();
	
	public JobDTO createAJob(JobDTO jobDTO, String authToken);
	public List<JobDTO> searchByLocation(String location);
	
	public JobDTO getJobByID(int id,String authToken);
	
	public Boolean applyForJob(JobDTO jobDto, String authToken);
	
	

}
