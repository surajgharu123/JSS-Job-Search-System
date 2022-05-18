package com.jss.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jss.employee.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{

}
