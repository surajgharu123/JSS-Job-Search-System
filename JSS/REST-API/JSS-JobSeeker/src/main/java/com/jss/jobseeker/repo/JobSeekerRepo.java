package com.jss.jobseeker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jss.jobseeker.entity.JobSeekerEntity;


public interface JobSeekerRepo extends JpaRepository<JobSeekerEntity, Integer>{
	
	public JobSeekerEntity findByUsername(String username);
	
	public List<JobSeekerEntity> findByJobID(int id);

}
