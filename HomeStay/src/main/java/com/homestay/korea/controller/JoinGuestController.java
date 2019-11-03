package com.homestay.korea.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homestay.korea.HomeController;
import com.homestay.korea.DTO.MemberDTO;
import com.homestay.korea.service.IJoinMemberService;

@Controller
public class JoinGuestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private IJoinMemberService joinmemberservice; 

	
	@GetMapping("/member/joinGuest")
	public void ViewJoinForm() {
	}
		
	
	
	@PostMapping("/join")
	public String joinmemberPOST(MemberDTO memberdto) {
		joinmemberservice.insertMember(memberdto);
		return "/member/loginForm";
		
	}
}
