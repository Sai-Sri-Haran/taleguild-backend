package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{
	
	 @Query("FROM UserModel WHERE email=:email")
	    UserModel findByEmail(@Param("email") String email);
}
