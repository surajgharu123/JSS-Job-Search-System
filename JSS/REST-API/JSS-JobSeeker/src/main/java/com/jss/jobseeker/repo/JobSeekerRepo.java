package com.jss.jobseeker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jss.jobseeker.entity.JobSeekerEntity;


public interface JobSeekerRepo extends JpaRepository<JobSeekerEntity, Integer>{
	
	public JobSeekerEntity findByUsername(String username);

}
