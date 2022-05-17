package com.jss.jobseeker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jss.jobseeker.dto.JobDTO;
import com.jss.jobseeker.entity.JobEntity;

public interface JobSeekerRepo extends JpaRepository<JobEntity, Integer> {

	@Query(value = "SELECT jobTitle, location, description, experience, salary, noticePeriod, ContactEmail, Status FROM JobEntity")
	public List<JobEntity> getAllJobs();
}
