package com.jss.employee.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.jss.employee.dto.Employee;

class EmployeeServiceTest {

	EmployeeService employeeService = mock(EmployeeService.class);
	@Test
	void testUpdateById() {
		Employee employee = new Employee();
		employee.setJobTitle("SDE");
		employee.setLocation("Pune");
		when(employeeService.updateJob(1, employee)).thenReturn(employee);
		
		assertEquals(employeeService.updateJob(1, employee).getLocation(), "Pune");
		
	}

}
