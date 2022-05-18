package com.jss.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jss.user.entity.UserJobSeekerEntity;

public interface UserJobSeekerRepo extends JpaRepository<UserJobSeekerEntity, Integer>{
	
	List<UserJobSeekerEntity> findByUsername(String username);
    
}
