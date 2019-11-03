package com.homestay.korea.controller;

import java.sql.SQLException;
import java.util.Locale;

import javax.activation.CommandMap;
import javax.annotation.Resource;
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
import org.springframework.web.servlet.ModelAndView;

import com.homestay.korea.HomeController;
import com.homestay.korea.DTO.MemberDTO;
import com.homestay.korea.service.IJoinMemberService;

@Controller
public class JoinGuestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	public IJoinMemberService memberservice;
	
	@GetMapping("/member/joinGuest")
	public void ViewJoinGeustForm() {
		
	}
	
	@RequestMapping(value="/join",method= RequestMethod.POST)
	public String joinGeust(MemberDTO dto) throws SQLException {
		memberservice.insertMember(dto);
		return "/main";
		
	}
	
	

}
