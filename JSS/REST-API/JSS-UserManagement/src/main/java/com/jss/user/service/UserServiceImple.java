package com.jss.user.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.jss.user.dto.UserDTO;
import com.jss.user.employee.security.JwtUtil;
import com.jss.user.entity.UserEntity;
import com.jss.user.exception.InvalidCredentialsException;
import com.jss.user.repo.UserRepo;

import java.util.Map;


import org.modelmapper.TypeMap;

import org.modelmapper.ModelMapper;


@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	AuthenticationManager authenticationManager;
	@Override
	public String authenticateEmployee(UserDTO userDTO) {
		try {
			this.authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(userDTO.getUserName(), userDTO.getPassword()));
			}
			catch(AuthenticationException ex) {
			throw new InvalidCredentialsException(ex.toString());
			}
			String jwt=jwtUtil.generateToken(userDTO.getUserName());
			return jwt;



	}
	@Override
	public UserDTO getUserRegistration(UserDTO login) {
		UserEntity userEntity = convertDTOIEntity(login);
		userEntity = userRepo.save(userEntity);

		return convertEntityIDTO(userEntity);
	}
	private UserEntity convertDTOIEntity(UserDTO login) {
       UserEntity userEntity = modelMapper.map(login, UserEntity.class);
		
		return userEntity;
	}
	@Override
	public UserDTO createEmployee(String authToken) {

		return null;
	}
	private UserDTO convertEntityIDTO(UserEntity userEntity) {

		UserDTO user = modelMapper.map(userEntity, UserDTO.class);
		return user;
	}

}

