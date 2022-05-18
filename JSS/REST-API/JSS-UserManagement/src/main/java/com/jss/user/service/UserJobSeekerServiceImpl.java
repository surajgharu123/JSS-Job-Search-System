package com.jss.user.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeMap;

import com.jss.user.dto.UserJobSeekerDTO;
import com.jss.user.entity.UserJobSeekerEntity;
import com.jss.user.exception.InvalidCredentialsException;
import com.jss.user.repo.UserJobSeekerRepo;
import com.jss.user.security.JwtUtil;

@Service
public class UserJobSeekerServiceImpl implements UserJobSeekerService {

	@Autowired
	UserJobSeekerRepo userJobRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	JwtUtil jwtUtil;

	
	@Autowired
	@Qualifier("UserDetailsServiceForJobseeker")
	UserDetailsService userDetailsServiceForJobSeeker;
	
	
	@Autowired
	@Qualifier("authenticationManagerForJobseeker")
	AuthenticationManager authenticationManagerForJobseeker;
	

	@Override
	public UserJobSeekerDTO registerUserJobSeeker(UserJobSeekerDTO userJobDTO) {

		UserJobSeekerEntity userJobEntity = convertDTOintoEntity(userJobDTO);
		userJobEntity = userJobRepo.save(userJobEntity);

		return convertEntityintoDTO(userJobEntity);
	}

	private UserJobSeekerDTO convertEntityintoDTO(UserJobSeekerEntity userJobEntity) {
		TypeMap<UserJobSeekerEntity, UserJobSeekerDTO> typemap = modelMapper.typeMap(UserJobSeekerEntity.class,
				UserJobSeekerDTO.class);
		typemap.addMappings(mapper -> {

			mapper.map(userJbEntity -> userJbEntity.getName(), UserJobSeekerDTO::setName);

		});
		UserJobSeekerDTO userJobDto = modelMapper.map(userJobEntity, UserJobSeekerDTO.class);
		return userJobDto;
	}

	private UserJobSeekerEntity convertDTOintoEntity(UserJobSeekerDTO userJobDTO) {

		TypeMap<UserJobSeekerDTO, UserJobSeekerEntity> typemap = modelMapper.typeMap(UserJobSeekerDTO.class,
				UserJobSeekerEntity.class);
		typemap.addMappings(mapper -> {
			mapper.map(userJobDto -> userJobDto.getName(), UserJobSeekerEntity::setName);

		});
		UserJobSeekerEntity userJobEntity = modelMapper.map(userJobDTO, UserJobSeekerEntity.class);
		return userJobEntity;
	}

	@Override
	public String authenticateUserJobLogin(UserJobSeekerDTO userJobDTO) {

		try {
			this.authenticationManagerForJobseeker.authenticate(
					new UsernamePasswordAuthenticationToken(userJobDTO.getUsername(), userJobDTO.getPassword()));
		} catch (AuthenticationException ex) {
			throw new InvalidCredentialsException(ex.toString());
		}
		String jwt = jwtUtil.generateToken(userJobDTO.getUsername());
		return jwt;

	}
	
	@Override
	public Boolean validationAuthToken(String authToken) {
		// TODO Auto-generated method stub
		authToken = authToken.substring(7);
		String username = jwtUtil.extractUsername(authToken);
	    UserDetails userDetails	= userDetailsServiceForJobSeeker.loadUserByUsername(username);
		//UserJobSeekerEntity userSeekerEntity = userJobSeekerEntities.get(0);
		
		return jwtUtil.validateToken(authToken, userDetails);
	}

}
