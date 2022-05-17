package com.jss.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeMap;

import com.jss.user.dto.UserJobDTO;
import com.jss.user.entity.UserJobEntity;
import com.jss.user.exception.InvalidCredentialsException;
import com.jss.user.jobseeker.security.JwtUtil;
import com.jss.user.repo.UserJobRepo;

@Service
public class UserJobServiceImpl implements UserJobService{
	
	@Autowired
	UserJobRepo userJobRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	

	@Override
	public UserJobDTO registerUserJobSeeker(UserJobDTO userJobDTO) {
		
		UserJobEntity userJobEntity=convertDTOintoEntity(userJobDTO);
		userJobEntity=userJobRepo.save(userJobEntity);
	
		return convertEntityintoDTO(userJobEntity);
	}
	private UserJobDTO convertEntityintoDTO(UserJobEntity userJobEntity) {
		TypeMap<UserJobEntity,UserJobDTO> typemap=modelMapper.typeMap(UserJobEntity.class, UserJobDTO.class);
	typemap.addMappings(mapper->{
	
		mapper.map(userJbEntity->userJbEntity.getName(), UserJobDTO::setName);

	
	});
	UserJobDTO userJobDto=modelMapper.map(userJobEntity, UserJobDTO.class);
		return userJobDto;
	}
	
private UserJobEntity convertDTOintoEntity(UserJobDTO userJobDTO) {
		
		TypeMap<UserJobDTO,UserJobEntity> typemap=modelMapper.typeMap(UserJobDTO.class, UserJobEntity.class);
		typemap.addMappings(mapper->{
			mapper.map(userJobDto->userJobDto.getName(), UserJobEntity::setName);
		

		});
		UserJobEntity userJobEntity=modelMapper.map(userJobDTO, UserJobEntity.class);
		return userJobEntity;
	}
@Override
public String authenticateUserJobLogin(UserJobDTO userJobDTO) {

	try {
		this.authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(userJobDTO.getUsername(), userJobDTO.getPassword()));
	}
	catch(AuthenticationException ex) {
		throw new InvalidCredentialsException(ex.toString());
	}
	String jwt=jwtUtil.generateToken(userJobDTO.getUsername());
		return jwt;

}

}
