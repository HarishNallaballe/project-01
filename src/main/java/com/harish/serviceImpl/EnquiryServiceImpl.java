package com.harish.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.harish.binding.SearchCriteria;
import com.harish.entity.EnquiryEntity;
import com.harish.repo.EnquiryRepo;
import com.harish.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	private EnquiryRepo enquiryRepo;

	@Override
	public String addEnquiry(EnquiryEntity enquiryEntity) {
		EnquiryEntity save = enquiryRepo.save(enquiryEntity);
		if(save.getEid()!=null) {
			return "Enquiry Added";
		}else {
			return "Enquiry Not Added";
		}
	}

	@Override
	public List<EnquiryEntity> getEnquiries(Integer id,SearchCriteria sc) {
		
		EnquiryEntity eq=new EnquiryEntity();
		eq.setCouEntity(id);
		
		
		if(sc.getCourse()!=null && !sc.getCourse().equals("")) {
		    eq.setCourse(sc.getCourse());
		}
		if(sc.getMode()!=null && !sc.getMode().equals("")) {
			eq.setMode(sc.getMode());
		}
		if(sc.getStatus()!=null && !sc.getStatus().equals("")) {
			eq.setStatus(sc.getStatus());
		}
		Example<EnquiryEntity> ex=Example.of(eq);		
		 return enquiryRepo.findAll(ex);
		
	//	List<EnquiryEntity> enq = enquiryRepo.findByCid(id);
	//	return enq;
		
	}

}
