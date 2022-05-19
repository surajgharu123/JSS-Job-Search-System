package com.jss.jobseeker.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jss.jobseeker.dto.JobDTO;
import com.jss.jobseeker.entity.JobEntity;

public interface JobRepo extends JpaRepository<JobEntity, Integer> {

	@Query(value = "SELECT jobTitle, location, description, experience, salary, noticePeriod, ContactEmail, Status FROM JobEntity")
	public List<JobEntity> getAllJobs();
	
	@Query(value = "FROM JobEntity where jobTitle=:jobTitle and location=:location and description=:description and Status=:status and companyName=:companyName")
	public Optional<JobEntity> getIdOfJob(String jobTitle,String location, String description,String status, String companyName);

}
