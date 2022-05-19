package com.jss.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jss.employee.dto.Employee;
import com.jss.employee.dto.Job;
import com.jss.employee.entity.EmployeeEntity;
import com.jss.employee.entity.JobEntity;
import com.jss.employee.exception.InvalidAuthTokenException;
import com.jss.employee.exception.InvalidIdException;
import com.jss.employee.repo.JobRepo;


@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	EmployeeServiceDelegate employeeServiceDelegate;
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	JobRepo jobRepo;


	
	private Job convertEntityIntoDTO(JobEntity jobEntity) {
		Job job = modelMapper.map(jobEntity, Job.class);
		return job;
	}


	@Override
	public Boolean deleteJobById(int id) {
		jobRepo.deleteById(id);
		return true;
	}

//	@Override
//	public List<Job> searchByJobId(Integer id,String authToken) {
//		
//		if(employeeServiceDelegate.isTokenValid(authToken)) {
//		
//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<JobEntity> criteriaQuery = criteriaBuilder.createQuery(JobEntity.class);
//		Root<JobEntity> root = criteriaQuery.from(JobEntity.class);
//
//		Predicate predicateId = criteriaBuilder.and();
//		
//
//		if (id != null) {
//			predicateId = criteriaBuilder.equal(root.get("id"), id);
//		}
//
//		//root.get("id"), "%" + id + "%"
//		criteriaQuery.where(predicateId);
//	
//		TypedQuery<JobEntity> typedQuery = entityManager.createQuery(criteriaQuery);
//
//		List<JobEntity> jobEntityList = typedQuery.getResultList();
//		
//		List<Job> jobDTOs = new ArrayList<>();
//		for(JobEntity job : jobEntityList) {
//		jobDTOs.add(convertEntityIntoDTO(job));
//		}
//
//		if(jobDTOs.isEmpty())
//		{
//			throw new InvalidIdException("Entered Search Id not Avaiable");
//		}
//		return jobDTOs;
//	}
//		else 
//			throw new InvalidAuthTokenException(authToken);
//		
//	}


	@Override
	public List<Job> searchByJobId(Integer id,String authToken) {
		List<Job> jobDTOs = new ArrayList<>();
		if (employeeServiceDelegate.isTokenValid(authToken)) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<JobEntity> criteriaQuery = criteriaBuilder.createQuery(JobEntity.class);
		Root<JobEntity> root = criteriaQuery.from(JobEntity.class);
		Predicate predicateId = criteriaBuilder.and();
		if (id != null) {
		predicateId = criteriaBuilder.equal(root.get("id"), id);
		}
		// root.get("id"), "%" + id + "%"
		criteriaQuery.where(predicateId);
		TypedQuery<JobEntity> typedQuery = entityManager.createQuery(criteriaQuery);
		List<JobEntity> jobEntityList = typedQuery.getResultList();
		for (JobEntity job : jobEntityList) {
		jobDTOs.add(convertEntityIntoDTO(job));
		}
		if (jobDTOs.isEmpty()) {
		throw new InvalidIdException("Entered Search Id not Avaiable");
		}
		}
		return jobDTOs;
}
		


	@Override
	public Job updateJob(int id, Job job) {
		Optional<JobEntity> opJobEntity = jobRepo.findById(id);
		if(opJobEntity.isPresent()) {
			JobEntity jobEntity = opJobEntity.get();
			
			jobEntity.setContact_no(job.getContact_no());
			jobEntity.setDescription(job.getDescription());
			jobEntity.setExperience(job.getExperience());
			jobEntity.setJob_title(job.getJob_title());
			jobEntity.setLocation(job.getLocation());
			jobEntity.setNotice(job.getNotice());
			jobEntity.setSalary(job.getSalary());
			jobEntity.setStatus(job.getStatus());
			
			return convertEntityIntoDTO(jobRepo.save(jobEntity)) ;
		}
		
		else
			throw new InvalidIdException();
	}
	
	
	}
	
	


