package com.jss.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jss.user.entity.UserJobEntity;

public interface UserJobRepo extends JpaRepository<UserJobEntity, Integer>{
	
	List<UserJobEntity> findByUsername(String username);

}
