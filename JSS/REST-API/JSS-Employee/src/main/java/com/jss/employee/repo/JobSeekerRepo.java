package com.jss.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jss.employee.entity.JobSeekerEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jss.employee.entity.JobEntity;
import com.jss.employee.entity.JobSeekerEntity;

public interface JobSeekerRepo extends JpaRepository<JobSeekerEntity, Integer>{
	

}
