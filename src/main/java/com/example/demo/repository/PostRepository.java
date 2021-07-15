package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PostModel;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long>{
	PostModel findByEmail(String email);
	
	
//	@Query("update PostModel p set p.like= :like where p.id= :id")
//	void setupdateLike(@Param("like") int like,@Param("id") long id);
	
	
}
