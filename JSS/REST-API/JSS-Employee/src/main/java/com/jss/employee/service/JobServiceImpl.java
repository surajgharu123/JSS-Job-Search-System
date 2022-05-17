package com.jss.employee.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jss.employee.dto.Job;
import com.jss.employee.entity.JobEntity;


@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	ModelMapper modelMapper;


	
	private Job convertEntityIntoDTO(JobEntity jobEntity) {
		Job job = modelMapper.map(jobEntity, Job.class);
		return job;
	}



	@Override
	public List<Job> searchByJobId(Integer id) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<JobEntity> criteriaQuery = criteriaBuilder.createQuery(JobEntity.class);
		Root<JobEntity> root = criteriaQuery.from(JobEntity.class);

		Predicate predicateId = criteriaBuilder.and();
		

		if (id != null) {
			predicateId = criteriaBuilder.equal(root.get("id"), id);
		}

		//root.get("id"), "%" + id + "%"
		criteriaQuery.where(predicateId);
	
		TypedQuery<JobEntity> typedQuery = entityManager.createQuery(criteriaQuery);

		List<JobEntity> jobEntityList = typedQuery.getResultList();
		
		List<Job> jobDTOs = new ArrayList<>();
		for(JobEntity job : jobEntityList) {
		jobDTOs.add(convertEntityIntoDTO(job));
		}

		return jobDTOs;
	}
	}
	
	

