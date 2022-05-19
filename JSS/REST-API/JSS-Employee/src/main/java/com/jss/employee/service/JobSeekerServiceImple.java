package com.jss.employee.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.persistence.criteria.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jss.employee.dto.*;
import com.jss.employee.entity.JobEntity;
import com.jss.employee.entity.JobSeekerEntity;
import com.jss.employee.exception.DataNotFoundException;
import com.jss.employee.exception.InvalidAuthTokenException;
import com.jss.employee.repo.JobSeekerRepo;

@Service
public class JobSeekerServiceImple implements JobSeekerService {

	@Autowired
	EntityManager entityManager;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	JobSeekerRepo jobSeekerRepo;

	@Autowired
	EmployeeServiceDelegate employeeServiceDelegate;

//	@Override
//	public List<JobSeeker> filterAdvertise(String skillSet) {
//		
	@Override
	public List<JobSeeker> filterJobSeekerBySkills(String skillSet, String authToken) {

		List<JobSeeker> jobSeekerDTOs = new ArrayList<>();
		if (employeeServiceDelegate.isTokenValid(authToken)) {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<JobSeekerEntity> criteriaQuery = criteriaBuilder.createQuery(JobSeekerEntity.class);
			Root<JobSeekerEntity> root = criteriaQuery.from(JobSeekerEntity.class);

			Predicate predicateSkillSet = criteriaBuilder.and();
			if (skillSet != null && !"".equalsIgnoreCase(skillSet)) {
				predicateSkillSet = criteriaBuilder.like(root.get("skillset"), "%" + skillSet + "%");

				criteriaQuery.where(predicateSkillSet);

				TypedQuery<JobSeekerEntity> typedQuery = entityManager.createQuery(criteriaQuery);

				List<JobSeekerEntity> jobSeekerEntityList = typedQuery.getResultList();

				for (JobSeekerEntity jobseeker : jobSeekerEntityList) {
					jobSeekerDTOs.add(convertEntityIntoDTO(jobseeker));
				}

				if (jobSeekerDTOs.isEmpty()) {
					throw new DataNotFoundException();
				}

			}

		} else
			throw new InvalidAuthTokenException();
		return jobSeekerDTOs;

	}

	private JobSeeker convertEntityIntoDTO(JobSeekerEntity jobSeekerEntity) {
		JobSeeker jobSeeker = modelMapper.map(jobSeekerEntity, JobSeeker.class);
		return jobSeeker;
	}


}
