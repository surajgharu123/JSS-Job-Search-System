package com.jss.user.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import com.jss.user.dto.UserEmployeeDTO;
import com.jss.user.entity.UserEmployeeEntity;
import com.jss.user.exception.InvalidCredentialsException;
import com.jss.user.repo.UserEmployeeRepo;
import com.jss.user.security.JwtUtil;

import org.modelmapper.ModelMapper;
@Service
public class UserEmployeeServiceImple implements UserEmployeeService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserEmployeeRepo userRepo;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	AuthenticationManager authenticationManager;
	@Override
	public String authenticateEmployee(UserEmployeeDTO userDTO) {
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
	public UserEmployeeDTO getUserRegistration(UserEmployeeDTO login) {
		UserEmployeeEntity userEntity = convertDTOIEntity(login);
		userEntity = userRepo.save(userEntity);

		return convertEntityIDTO(userEntity);
	}
	private UserEmployeeEntity convertDTOIEntity(UserEmployeeDTO login) {
       UserEmployeeEntity userEntity = modelMapper.map(login, UserEmployeeEntity.class);
		
		return userEntity;
	}
	@Override
	public UserEmployeeDTO createEmployee(String authToken) {

		return null;
	}
	private UserEmployeeDTO convertEntityIDTO(UserEmployeeEntity userEntity) {

		UserEmployeeDTO user = modelMapper.map(userEntity, UserEmployeeDTO.class);
		return user;
	}

}

