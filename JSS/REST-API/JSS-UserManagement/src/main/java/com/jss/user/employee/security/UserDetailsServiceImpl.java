package com.jss.user.employee.security;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jss.user.dto.UserDTO;
import com.jss.user.entity.UserEntity;
import com.jss.user.repo.UserRepo;
import com.jss.user.service.UserService;

import java.util.ArrayList;
import java.util.List;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{

@Autowired
PasswordEncoder passwordEncoder;

@Autowired
UserRepo userRepo;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



List<UserEntity> userEntityList= userRepo.findByUserName(username);



if(userEntityList==null || userEntityList.size()==0) {
throw new UsernameNotFoundException(username);
}
UserEntity userEntity=userEntityList.get(0);
List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
String roles=userEntity.getRole();
String rolesArray[]=roles.split(",");
for(String role:rolesArray) {
authorities.add(new SimpleGrantedAuthority(role));
}
UserDetails userDetails=new User(username,passwordEncoder.encode(userEntity.getPassword()),authorities);
return userDetails;
}







}
