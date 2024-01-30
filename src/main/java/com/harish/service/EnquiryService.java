package com.harish.service;

import java.util.List;

import com.harish.binding.SearchCriteria;
import com.harish.entity.EnquiryEntity;

public interface EnquiryService {

	public String addEnquiry(EnquiryEntity enquiryEntity);
	
	public List<EnquiryEntity> getEnquiries(Integer id,SearchCriteria sc);
	
}
