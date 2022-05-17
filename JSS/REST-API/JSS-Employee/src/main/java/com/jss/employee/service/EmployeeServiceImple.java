package com.jss.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jss.employee.dto.Employee;
import com.jss.employee.entity.EmployeeEntity;
import com.jss.employee.exception.InvalidIdException;
import com.jss.employee.repo.EmployeeRepo;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;


	@Override
	public Employee updateJob(int id, Employee employee) {
		Optional<EmployeeEntity> opemployeeEntity = employeeRepo.findById(id);
		if(opemployeeEntity.isPresent()) {
			EmployeeEntity employeeEntity = opemployeeEntity.get();
			employeeEntity.setUserName(employee.getUserName());
			employeeEntity.setPassword(employee.getPassword());
			employeeEntity.setOrgnizationName(employee.getOrgnizationName());
			employeeEntity.setAddress(employee.getAddress());
			employeeEntity.setJobTitle(employee.getJobTitle());
			employeeEntity.setLocation(employee.getLocation());
			employeeEntity.setDescription(employee.getDescription());
			employeeEntity.setExperience(employee.getExperience());
			employeeEntity.setSalary(employee.getSalary());
			employeeEntity.setNoticePeriod(employee.getNoticePeriod());
			employeeEntity.setContact(employee.getContact());
			employeeEntity.setEmail(employee.getEmail());
			employeeEntity.setStatus(employee.getStatus());
			employeeEntity = employeeRepo.save(employeeEntity);
			employeeRepo.save(employeeEntity);
		}
		else
		{
			throw new InvalidIdException();
		}
	    return employee;
	}

}
