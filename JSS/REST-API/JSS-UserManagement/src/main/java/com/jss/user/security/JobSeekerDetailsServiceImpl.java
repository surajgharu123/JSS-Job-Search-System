package com.jss.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jss.user.entity.UserEmployeeEntity;
import com.jss.user.entity.UserJobSeekerEntity;
import com.jss.user.repo.UserJobSeekerRepo;
import com.jss.user.repo.UserEmployeeRepo;

import java.util.ArrayList;
import java.util.List;

@Service("JobSeekerAuthenticationManager")
public class JobSeekerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserJobSeekerRepo userJobRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<UserJobSeekerEntity> userEntityList = userJobRepo.findByUsername(username);

		if (userEntityList == null) {

			throw new UsernameNotFoundException(username);
		}
		UserJobSeekerEntity userEntity = userEntityList.get(0);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		String roles = userEntity.getRoles();
		String rolesArray[] = roles.split(",");
		for (String role : rolesArray) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		UserDetails userDetails = new User(username, passwordEncoder.encode(userEntity.getPassword()), authorities);
		return userDetails;
	}

}
