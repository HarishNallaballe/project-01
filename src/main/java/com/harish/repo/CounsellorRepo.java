package com.harish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.entity.CounsellorEntity;

public interface CounsellorRepo extends JpaRepository<CounsellorEntity, Integer>{
	
	public CounsellorEntity findByEmail(String email);
	
	public CounsellorEntity findByEmailAndPassword(String email,String password);

}
