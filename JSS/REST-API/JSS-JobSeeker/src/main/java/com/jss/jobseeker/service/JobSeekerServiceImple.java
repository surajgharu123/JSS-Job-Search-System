package com.jss.jobseeker.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jss.jobseeker.dto.JobDTO;
import com.jss.jobseeker.entity.JobSeekerEntity;
import com.jss.jobseeker.repo.JobSeekerRepo;

@Service
public class JobSeekerServiceImple implements JobSeekerService {
	
	@Autowired
	JobSeekerRepo jobSeekerRepo;
	@Autowired
	EntityManager entityManager;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<JobDTO> SearchByFilterCriteria(String companyName, String skills, String jobTitle) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<JobSeekerEntity> criteriaQueryEntity = criteriaBuilder.createQuery(JobSeekerEntity.class);
		Root<JobSeekerEntity> rootDTO = criteriaQueryEntity.from(JobSeekerEntity.class);
		
		// Like, in , or , and  multiple 
		//where 
		/**
		 * root => {
		 * "" : ""
		 * }
		 */
		//SELECT * FROM JOB WHERE Infosys = %Zensar%;
		//
		Predicate companyNamePredicate = criteriaBuilder.and();
		Predicate skillsPredicate = criteriaBuilder.and();
		Predicate designationPredicate = criteriaBuilder.and();
		Predicate finalPredicate = criteriaBuilder.and();
		
		if(companyName != null && !"".equalsIgnoreCase(companyName)) {
			companyNamePredicate = criteriaBuilder.like(rootDTO.get("companyName"), "%" + companyName + "%");
		}
		if(skills != null && !"".equalsIgnoreCase(skills)) {
			skillsPredicate = criteriaBuilder.like(rootDTO.get("skills"), "%" + skills + "%");
		}
		if(jobTitle != null && !"".equalsIgnoreCase(jobTitle)) {
			designationPredicate = criteriaBuilder.like(rootDTO.get("jobTitle"), "%" + jobTitle +"%");
		}
		
		finalPredicate = criteriaBuilder.and(companyNamePredicate, skillsPredicate, designationPredicate);
		
		criteriaQueryEntity.where(finalPredicate);
		
		TypedQuery<JobSeekerEntity> typedQuery = entityManager.createQuery(criteriaQueryEntity);
		List<JobSeekerEntity> jobSeekerEntities = typedQuery.getResultList();
		List<JobDTO> jobSeekerDTOs = new ArrayList<>();
		for(JobSeekerEntity jobseeker : jobSeekerEntities) {
			jobSeekerDTOs.add(ConvertEntityToDTO(jobseeker));
		}
		
		
		return jobSeekerDTOs;
	}
	
	public JobSeekerEntity ConvertDTOToEntity(JobDTO jobSeekerDTO) {
		
		return modelMapper.map(jobSeekerDTO, JobSeekerEntity.class);
	}

	public JobDTO ConvertEntityToDTO(JobSeekerEntity jobSeekerEntity) {
		return modelMapper.map(jobSeekerEntity, JobDTO.class);
	}

	@Override
	public List<JobDTO> getAllRecords() {
		// TODO Auto-generated method stub
		List<JobSeekerEntity> jobSeekerEntities = jobSeekerRepo.getAllJobs();
		List<JobDTO> jobSeekerDTOs = new ArrayList<>();
		for(JobSeekerEntity jobseeker : jobSeekerEntities) {
			jobSeekerDTOs.add(ConvertEntityToDTO(jobseeker));
		}
		return jobSeekerDTOs;
	}

	@Override
	public JobDTO addrecords(JobDTO jobSeekerDTO) {
		
		// TODO Auto-generated method stub
		JobSeekerEntity jobSeekerEntity = jobSeekerRepo.save(ConvertDTOToEntity(jobSeekerDTO));
		return ConvertEntityToDTO(jobSeekerEntity);
	}

	@Override
	public List<JobDTO> searchByLocation(String location) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<JobSeekerEntity> criteriaQueryEntity = criteriaBuilder.createQuery(JobSeekerEntity.class);
		Root<JobSeekerEntity> rootDTO = criteriaQueryEntity.from(JobSeekerEntity.class);
		
		Predicate locationPredicate = criteriaBuilder.and();
		
		if(location != null && !"".equalsIgnoreCase(location)) {
			locationPredicate = criteriaBuilder.like(rootDTO.get("location"), "%" + location + "%");
		}
		
        criteriaQueryEntity.where(locationPredicate);
		
		TypedQuery<JobSeekerEntity> typedQuery = entityManager.createQuery(criteriaQueryEntity);
		List<JobSeekerEntity> jobSeekerEntities = typedQuery.getResultList();
		List<JobDTO> jobSeekerDTOs = new ArrayList<>();
		for(JobSeekerEntity jobseeker : jobSeekerEntities) {
			jobSeekerDTOs.add(ConvertEntityToDTO(jobseeker));
		}
		
		
		return jobSeekerDTOs;
	}
}
