package com.harish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harish.binding.DashBoardBinding;
import com.harish.binding.SearchCriteria;
import com.harish.entity.CounsellorEntity;
import com.harish.entity.EnquiryEntity;
import com.harish.repo.CounsellorRepo;
import com.harish.repo.EnquiryRepo;
import com.harish.service.CounsellorService;
import com.harish.service.EnquiryService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {
	
	@Autowired
	private CounsellorService coService;
	
	@Autowired
	private EnquiryService enService;

	@GetMapping("/")
	public String loginPage( Model model) {
		model.addAttribute("counsellorEntity", new CounsellorEntity());
		//model.addAttribute("userName", model)
		return "index";
	}
	
	@PostMapping("/login")
	public String handleLoginForm(Model model,CounsellorEntity coEntity,HttpServletRequest request) {
		 CounsellorEntity entity = coService.loginFunctonality(coEntity);
		
		 if(entity==null) {
		  model.addAttribute("msg", "Invalid Credentials");
		  return "login";
		 }
		 HttpSession session = request.getSession(true);
		 session.setAttribute("cid", entity.getCid());
		return "redirect:dashboard";
	}
	
	@GetMapping("/reg")
	public String registerPage(Model model) {
		model.addAttribute("counsellorEntity", new CounsellorEntity());
		return "register";
	}
	
	@PostMapping("/save")
	public String saveregistration(CounsellorEntity coEntity,Model model) {
		String message = coService.CounsellorRegistration(coEntity);
		model.addAttribute("message",message);
		return "register";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Object attribute = session.getAttribute("cid");
		Integer cid=(Integer) attribute;
		DashBoardBinding dashBoardInfo = coService.dashBoardInfo(cid);
		model.addAttribute("dashboard", dashBoardInfo);
		return "dashboard";
	}
	
	@GetMapping("/recoverypwd")
	public String showForgotPwdPage() {
		return "forgotpwd";
	}
	
	@GetMapping("/recover")
	public String handleForgotPwd(@RequestParam("email") String email,Model model) {
		boolean forgotPwd = coService.forgotPwd(email);
		if(forgotPwd) {
			model.addAttribute("smsg", "Password sent to your mail");
		}else {
			model.addAttribute("errmsg", "Invalid Mail");
		}
		return "forgotpwd";
	}
	
	@GetMapping("/viewenquiry")
	public String viewEnqiries(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Integer attribute = (Integer)session.getAttribute("cid");
		model.addAttribute("sc", new SearchCriteria());
		List<EnquiryEntity> enquiries = enService.getEnquiries(attribute,new SearchCriteria());
		model.addAttribute("listEnquiry", enquiries);
		return "viewenq";
	}
	
	@PostMapping("/filter")
	public String filterEnq(Model model,@ModelAttribute("sc") SearchCriteria sc,HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Integer attribute = (Integer)session.getAttribute("cid");
		List<EnquiryEntity> enquiries = enService.getEnquiries(attribute, sc);
		model.addAttribute("enquiries", enquiries);
		return "filterEnq";
	}
	
	
	@GetMapping("/addEnquiry")
	public String addEnquiry(Model model,EnquiryEntity enquiryEntity) {
		model.addAttribute("entity", new EnquiryEntity());
		return "addEnquiry";
	}
	
	@PostMapping("/add")
	public String handleAddEnquiry(Model model,HttpServletRequest request,@ModelAttribute("entity") EnquiryEntity entity) {
		HttpSession session = request.getSession(false);
		Object attribute = session.getAttribute("cid");
		Integer cid=(Integer) attribute;
		entity.setCouEntity(cid);
		String addEnquiry = enService.addEnquiry(entity);
		model.addAttribute("message", addEnquiry);
		return "addEnquiry";
	}
	
	
	
}
