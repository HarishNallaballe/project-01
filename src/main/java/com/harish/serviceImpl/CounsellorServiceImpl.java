package com.harish.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.binding.DashBoardBinding;
import com.harish.entity.CounsellorEntity;
import com.harish.entity.EnquiryEntity;
import com.harish.repo.CounsellorRepo;
import com.harish.repo.EnquiryRepo;
import com.harish.service.CounsellorService;
import com.harish.utils.EmailUtils;

import jakarta.mail.MessagingException;

@Service
public class CounsellorServiceImpl implements CounsellorService{
	
	@Autowired
	private CounsellorRepo coRepo;
	
	@Autowired
	private EnquiryRepo enRepo;
	
	@Autowired
	private EmailUtils utils;

	@Override
	public String CounsellorRegistration(CounsellorEntity coEntity) {
		
		CounsellorEntity counsellor = coRepo.findByEmail(coEntity.getEmail());
		if(counsellor!=null) {
			return "Duplicate Email";
		}
		CounsellorEntity saved = coRepo.save(coEntity);
		if(saved.getCid()!=null) {
			return "Counsellor Successfully saved";
		}else {
			return "Counsellor Not inserted succesfully";
		}
	}

	@Override
	public CounsellorEntity loginFunctonality(CounsellorEntity coEntity) {
          		return coRepo.findByEmailAndPassword(coEntity.getEmail(),coEntity.getPassword());
	}

	@Override
	public boolean forgotPwd(String email) {
		CounsellorEntity counsellor = coRepo.findByEmail(email);
		if(counsellor==null) {
			return false;
		}
		String subject="Recover Your Password";
		String body="<h1>Your password is"+counsellor.getPassword()+"</h1>";
		 return utils.sendEmail(subject, body, email);
	}

	@Override
	public DashBoardBinding dashBoardInfo(Integer cid) {
		List<EnquiryEntity> list = enRepo.findByCid(cid);
		int enrolled = list.stream().filter(s->s.getStatus().equals("enrolled")).collect(Collectors.toList()).size();
		DashBoardBinding binding = new DashBoardBinding();
		binding.setEnquiries(list.size());
		binding.setLost(list.size()-enrolled);
		binding.setEnrolled(enrolled);
		return binding;
	}

}
