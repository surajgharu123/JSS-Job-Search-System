package com.jss.employee.service;

import java.util.List;

import com.jss.employee.dto.Job;
import com.jss.employee.dto.JobSeeker;

public interface JobService {

	List<Job> searchByJobId(Integer id);

}
