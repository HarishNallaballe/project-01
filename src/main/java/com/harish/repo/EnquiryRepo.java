package com.harish.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.entity.EnquiryEntity;

public interface EnquiryRepo extends JpaRepository<EnquiryEntity, Integer>{

	public List<EnquiryEntity> findByCid(Integer cid);
	
}
