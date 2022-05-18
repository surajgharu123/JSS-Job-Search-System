package com.jss.user.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jss.user.entity.UserEmployeeEntity;


public interface UserEmployeeRepo extends JpaRepository<UserEmployeeEntity, Integer> {

	//@Query(value = "SELECT job_title, location, description, experience, salary, notice_period, contact_email, status FROM JOB", nativeQuery = true)
	//public List<JobSeekerEntity> getAllJobs();
	public List<UserEmployeeEntity> findByUserName(String userName);
}
