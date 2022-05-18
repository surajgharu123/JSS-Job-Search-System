package com.jss.jobseeker.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.jss.jobseeker.dto.JobDTO;


public interface JobSeekerService {
	
	public List<JobDTO> SearchByFilterCriteria(String company, String skills, String designation);
	
	public List<JobDTO> getAllRecords();
	
	public JobDTO addrecords(JobDTO jobDTO);
	public List<JobDTO> searchByLocation(String location);
	
	public JobDTO getJobByID(int id);
	
	public Boolean applyForJob(JobDTO jobDto);
	
	

}
