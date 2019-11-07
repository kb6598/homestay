package com.homestay.korea.controller;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homestay.korea.HomeController;

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/common/bootstrap", method = RequestMethod.GET)
	public String top(Locale locale, Model model) {

		
		return "homestay/common/bootstrap";
	}
	
	//페이지 최상단 로고와 sign in sign up 버튼
	@RequestMapping(value = "/mainpage/top")
	public String top(HttpServletRequest httpServletRequest, Model model, HttpSession session) {
		if(session.getAttribute("memberInfo") != null) {
			model.addAttribute("memberinfo",session.getAttribute("memberInfo"));
			return "homestay/common/top_login";
		}else {
			return "homestay/common/top_no_login";
		}					
	}
	//로그아웃 기능
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest httpServletRequest, Model model, HttpSession session) {
		if(session.getAttribute("memberInfo") != null) {
			session.removeAttribute("memberInfo");			
		}
		return "redirect:main";
	}
	
	
}
