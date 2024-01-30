package com.harish.service;

import org.springframework.stereotype.Service;

import com.harish.binding.DashBoardBinding;
import com.harish.entity.CounsellorEntity;

@Service
public interface CounsellorService {

	public String CounsellorRegistration(CounsellorEntity coEntity);

	public CounsellorEntity loginFunctonality(CounsellorEntity coEntity);
	
	public boolean forgotPwd(String email);
	
	public DashBoardBinding dashBoardInfo(Integer cid);
	
}
