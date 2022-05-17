package com.jss.jobseeker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jss.jobseeker.dto.JobDTO;
import com.jss.jobseeker.entity.JobSeekerEntity;

public interface JobSeekerRepo extends JpaRepository<JobSeekerEntity, Integer> {

	@Query(value = "SELECT job_title, location, description, experience, salary, notice_period, contact_email, status FROM JOB", nativeQuery = true)
	public List<JobSeekerEntity> getAllJobs();
}
