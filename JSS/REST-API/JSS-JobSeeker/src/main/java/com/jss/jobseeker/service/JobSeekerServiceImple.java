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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jss.jobseeker.dto.JobDTO;
import com.jss.jobseeker.dto.JobSeekerDTO;
import com.jss.jobseeker.entity.JobEntity;
import com.jss.jobseeker.entity.JobSeekerEntity;
import com.jss.jobseeker.exception.InvalidAuthTokenException;
import com.jss.jobseeker.exception.InvalidJobSeekerException;
import com.jss.jobseeker.exception.InvalidSearchingDataException;
import com.jss.jobseeker.repo.JobRepo;
import com.jss.jobseeker.repo.JobSeekerRepo;

@Service
public class JobSeekerServiceImple implements JobSeekerService {

	@Autowired
	JobRepo jobSeeker;

	@Autowired
	JobSeekerRepo jobSeerkRepo;
	@Autowired
	EntityManager entityManager;
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UserManagementDelegate userManagementDelegate;

	@Autowired
	RestTemplate restTemplate;

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

		if (companyName != null && !"".equalsIgnoreCase(companyName)) {
			companyNamePredicate = criteriaBuilder.like(rootDTO.get("companyName"), "%" + companyName + "%");
		}
		if (skills != null && !"".equalsIgnoreCase(skills)) {
			skillsPredicate = criteriaBuilder.like(rootDTO.get("skills"), "%" + skills + "%");
		}
		if (jobTitle != null && !"".equalsIgnoreCase(jobTitle)) {
			designationPredicate = criteriaBuilder.like(rootDTO.get("jobTitle"), "%" + jobTitle + "%");
		}

		finalPredicate = criteriaBuilder.and(companyNamePredicate, skillsPredicate, designationPredicate);

		criteriaQueryEntity.where(finalPredicate);

		TypedQuery<JobEntity> typedQuery = entityManager.createQuery(criteriaQueryEntity);
		List<JobEntity> jobEntities = typedQuery.getResultList();
		List<JobDTO> jobDTOs = new ArrayList<>();
		for (JobEntity jobEntity : jobEntities) {
			jobDTOs.add(ConvertEntityToDTO(jobEntity));
		}

		if (jobDTOs.isEmpty()) {
			throw new InvalidSearchingDataException("Seaching Data is not Found");
		}

		return jobDTOs;
	}

	@Override
	public List<JobDTO> getAllRecords() {
		// TODO Auto-generated method stub
		List<JobEntity> jobEntities = jobSeeker.findAll();
		List<JobDTO> jobDTOs = new ArrayList<>();
		for (JobEntity jobEntity : jobEntities) {
			jobDTOs.add(ConvertEntityToDTO(jobEntity));
		}
		return jobDTOs;
	}

	@Override
	public JobDTO createAJob(JobDTO jobSeekerDTO, String authToken) {

		// TODO Auto-generated method stub
		if (userManagementDelegate.isTokenValidForEmployee(authToken)) {
			JobEntity jobSeekerEntity = jobSeeker.save(ConvertDTOToEntity(jobSeekerDTO));

			return ConvertEntityToDTO(jobSeekerEntity);
		} else
			throw new InvalidAuthTokenException();
	}

	@Override
	public List<JobDTO> searchByLocation(String location) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<JobEntity> criteriaQueryEntity = criteriaBuilder.createQuery(JobEntity.class);
		Root<JobEntity> rootDTO = criteriaQueryEntity.from(JobEntity.class);

		Predicate locationPredicate = criteriaBuilder.and();

		if (location != null && !"".equalsIgnoreCase(location)) {
			locationPredicate = criteriaBuilder.like(rootDTO.get("location"), "%" + location + "%");
		}

		criteriaQueryEntity.where(locationPredicate);

		TypedQuery<JobEntity> typedQuery = entityManager.createQuery(criteriaQueryEntity);
		List<JobEntity> jobEntities = typedQuery.getResultList();
		List<JobDTO> jobDTOs = new ArrayList<>();
		for (JobEntity jobEntity : jobEntities) {
			jobDTOs.add(ConvertEntityToDTO(jobEntity));
		}

		if (jobDTOs.isEmpty()) {
			throw new InvalidSearchingDataException("Entered Location is not Found");
		}

		return jobDTOs;
	}

	@Override
	public Boolean applyForJob(JobDTO jobDto, String authToken) {

		if (userManagementDelegate.isTokenValidForJobseeker(authToken)) {
			Optional<JobEntity> jodDetails = jobSeeker.getIdOfJob(jobDto.getJobTitle(), jobDto.getLocation(),
					jobDto.getDescription(), jobDto.getStatus(), jobDto.getCompanyName());
			if (jodDetails.isPresent()) {
				Integer jobId = ConvertEntityToDTO(jodDetails.get()).getId();
				String username = userManagementDelegate.getUserName(authToken);

				if (username != null) {
					JobSeekerEntity jobSeekerEntity = jobSeerkRepo.findByUsername(username);
					jobSeekerEntity.setJobID(jobId);
					jobSeerkRepo.save(jobSeekerEntity);
				}
				return true;
			}
			throw new InvalidJobSeekerException("This Job details is not presnt in database");
		}
		throw new InvalidAuthTokenException();
	}

	public JobEntity ConvertDTOToEntity(JobDTO jobDTO) {

		return modelMapper.map(jobDTO, JobEntity.class);
	}

	public JobDTO ConvertEntityToDTO(JobEntity jobEntity) {
		return modelMapper.map(jobEntity, JobDTO.class);
	}

	@Override
	public JobDTO getJobByID(int id, String authToken) {
		// TODO Auto-generated method stub
		if (userManagementDelegate.isTokenValidForEmployee(authToken)) {
			Optional<JobEntity> jobEntity = jobSeeker.findById(id);
			if (jobEntity.isPresent()) {
				return ConvertEntityToDTO(jobEntity.get());

			}
			throw new InvalidSearchingDataException("Id is not Found");

		}
		throw new InvalidAuthTokenException("Invalid Auth-Token");

	}

	@Override
	public List<JobSeekerDTO> getJobSeekerDetails(String auth) {
		// TODO Auto-generated method stub
		if (userManagementDelegate.isTokenValidForEmployee(auth)) {
			List<JobSeekerEntity> jobSeekerLists = jobSeerkRepo.findAll();
			List<JobSeekerDTO> jobSeekerdto = new ArrayList<>();
			for (JobSeekerEntity jobSeekerEntity : jobSeekerLists) {
				jobSeekerdto.add(ConvertEntityToDTO(jobSeekerEntity));
			}
			return jobSeekerdto;
		}
		return null;
	}

	public JobSeekerEntity ConvertDTOToEntity(JobSeekerDTO jobSeekerDTO) {

		return modelMapper.map(jobSeekerDTO, JobSeekerEntity.class);
	}

	public JobSeekerDTO ConvertEntityToDTO(JobSeekerEntity jobSeekerEntity) {
		return modelMapper.map(jobSeekerEntity, JobSeekerDTO.class);
	}

}
