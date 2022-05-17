package com.jss.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jss.employee.entity.JobEntity;


public interface JobRepo extends JpaRepository<JobEntity, Integer>{

}
