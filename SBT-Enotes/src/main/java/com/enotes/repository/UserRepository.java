package com.enotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enotes.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls,Integer>{
	
	public UserDtls findByEmail(String email);

}