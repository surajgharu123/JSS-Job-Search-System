package com.jss.jobseeker.service;

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

import com.jss.jobseeker.dto.JobDTO;
import com.jss.jobseeker.entity.JobEntity;
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
		CriteriaQuery<JobEntity> criteriaQueryEntity = criteriaBuilder.createQuery(JobEntity.class);
		Root<JobEntity> rootDTO = criteriaQueryEntity.from(JobEntity.class);
		
		
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
		
		TypedQuery<JobEntity> typedQuery = entityManager.createQuery(criteriaQueryEntity);
		List<JobEntity> jobEntities = typedQuery.getResultList();
		List<JobDTO> jobDTOs = new ArrayList<>();
		for(JobEntity jobEntity : jobEntities) {
			jobDTOs.add(ConvertEntityToDTO(jobEntity));
		}
		
		
		return jobDTOs;
	}
	
	public JobEntity ConvertDTOToEntity(JobDTO jobSeekerDTO) {
		
		return modelMapper.map(jobSeekerDTO, JobEntity.class);
	}

	public JobDTO ConvertEntityToDTO(JobEntity jobSeekerEntity) {
		return modelMapper.map(jobSeekerEntity, JobDTO.class);
	}

	@Override
	public List<JobDTO> getAllRecords() {
		// TODO Auto-generated method stub
		List<JobEntity> jobEntities = jobSeekerRepo.findAll();
		List<JobDTO> jobDTOs = new ArrayList<>();
		for(JobEntity jobEntity : jobEntities) {
			jobDTOs.add(ConvertEntityToDTO(jobEntity));
		}
		return jobDTOs;
	}

	@Override
	public JobDTO addrecords(JobDTO jobSeekerDTO) {
		
		// TODO Auto-generated method stub
		JobEntity jobSeekerEntity = jobSeekerRepo.save(ConvertDTOToEntity(jobSeekerDTO));
		return ConvertEntityToDTO(jobSeekerEntity);
	}

	@Override
	public List<JobDTO> searchByLocation(String location) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<JobEntity> criteriaQueryEntity = criteriaBuilder.createQuery(JobEntity.class);
		Root<JobEntity> rootDTO = criteriaQueryEntity.from(JobEntity.class);
		
		Predicate locationPredicate = criteriaBuilder.and();
		
		if(location != null && !"".equalsIgnoreCase(location)) {
			locationPredicate = criteriaBuilder.like(rootDTO.get("location"), "%" + location + "%");
		}
		
        criteriaQueryEntity.where(locationPredicate);
		
		TypedQuery<JobEntity> typedQuery = entityManager.createQuery(criteriaQueryEntity);
		List<JobEntity> jobEntities = typedQuery.getResultList();
		List<JobDTO> jobDTOs = new ArrayList<>();
		for(JobEntity jobEntity : jobEntities) {
			jobDTOs.add(ConvertEntityToDTO(jobEntity));
		}
		
		
		return jobDTOs;
	}

	@Override
	public JobDTO getJobByID(int id) {
		// TODO Auto-generated method stub
		
		Optional<JobEntity> jobEntity = jobSeekerRepo.findById(id);
		if(jobEntity.isPresent())
		{
			return ConvertEntityToDTO(jobEntity.get());
			
		}
		return null;
	}
}
