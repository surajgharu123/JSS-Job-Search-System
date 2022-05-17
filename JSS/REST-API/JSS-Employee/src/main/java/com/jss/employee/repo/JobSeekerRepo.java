package com.jss.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jss.employee.entity.JobSeekerEntity;

public interface JobSeekerRepo extends JpaRepository<JobSeekerEntity, Integer>{

}
