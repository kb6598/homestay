package com.homestay.korea.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homestay.korea.DTO.MemberDTO;
import com.homestay.korea.service.IMemberReadService;
import com.homestay.korea.service.MemberExistsService;

@Controller
public class LoginFormController {
	
	@Autowired
	private MemberExistsService mExistsService;
	
	@Autowired
	private IMemberReadService mMemberReadService;
	
	@GetMapping("/member/loginForm")
	public void goLoginForm() {
		
	}
	
	@PostMapping("/login")
	public String memberLogin(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) {
		
		
		if(!checkInput(id) || !checkInput(pw)) {
			return "/member/loginForm";
		}
		
		if(!mExistsService.isExistsId(id)) {
			return "/member/loginForm"; 
		}
		
		MemberDTO member = mMemberReadService.getMember(id);
		if(!(member.getPw().equals(pw))) {
			return "/member/loginForm";
		}
		
		session.setAttribute("memberInfo", member);
		return "/main";
	}
	
	private boolean checkInput(String inputString) {
		if(inputString.equals("") || inputString.isEmpty()) {
			return false;
		}
		return true;
	}
	
}













