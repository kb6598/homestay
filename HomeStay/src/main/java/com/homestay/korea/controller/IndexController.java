package com.homestay.korea.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homestay.korea.HomeController;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/mainpage/top")
	public String top(Locale locale, Model model) {

		
		return "homestay/mainPage/top";
	}
	@RequestMapping(value = "/mainpage/topview")
	public String topview(HttpServletRequest httpServletRequest, Model model) {
		model.addAttribute("image_1","https://cdn.pixabay.com/photo/2018/06/16/07/48/nature-3478370_960_720.jpg");
		model.addAttribute("image_2","https://upload.wikimedia.org/wikipedia/commons/a/ab/%EA%B4%91%EC%A3%BC%EB%8C%80_%EB%B4%84%ED%92%8D%EA%B2%BD.jpg");
		model.addAttribute("image_3","https://i0.hippopx.com/photos/174/613/190/mountain-landscape-mountains-landscape-steinweg-preview.jpg");
		return "homestay/mainPage/topView";
	}
	@RequestMapping(value = "/mainpage/menu")
	public String menu(Locale locale, Model model) {

		
		return "homestay/mainPage/menu";
	}
	@RequestMapping(value = "/mainpage/mainview")
	public String mainview(Locale locale, Model model) {

		
		return "homestay/mainPage/mainView";
	}
	@RequestMapping(value = "/mainpage/subview")
	public String subview(HttpServletRequest httpServletRequest, Model model) {
		
		String theme = httpServletRequest.getAttribute("theme").toString();
		String theme_kor = httpServletRequest.getAttribute("theme").toString();
		
		model.addAttribute("theme_kor",theme_kor);
		model.addAttribute("theme",theme);
		
		return "homestay/mainPage/subView";
	}

	@RequestMapping(value = "/main")
	public String index(Locale locale, Model model) {

//		전체
//		서울
//		경기
//		인천
//		강원
//		충청
//		대구
//		부산
//		울산
//		광주
//		제주
		
		
		
		return "homestay/mainPage/index";
	}
	
	
}
