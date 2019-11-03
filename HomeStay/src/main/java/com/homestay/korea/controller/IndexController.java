package com.homestay.korea.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
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
	public String top(HttpServletRequest httpServletRequest, Model model) {

		
		return "homestay/mainPage/top";
	}
	@RequestMapping(value = "/mainpage/topview")
	public String topview(HttpServletRequest httpServletRequest, Model model) {
		model.addAttribute("image_1","https://cdn.pixabay.com/photo/2018/06/16/07/48/nature-3478370_960_720.jpg");
		model.addAttribute("image_2","https://upload.wikimedia.org/wikipedia/commons/a/ab/%EA%B4%91%EC%A3%BC%EB%8C%80_%EB%B4%84%ED%92%8D%EA%B2%BD.jpg");
		model.addAttribute("image_3","https://i0.hippopx.com/photos/174/613/190/mountain-landscape-mountains-landscape-steinweg-preview.jpg");
		return "homestay/mainPage/topView";
	}
	@RequestMapping(value = "/mainpage/menu", method=RequestMethod.GET)
	public String menu(HttpServletRequest httpServletRequest, Model model) {
		String location = httpServletRequest.getParameter("location").toString();
		//model.addAllAttributes(httpServletRequest.getParameterMap());
		model.addAttribute("location",location);
		return "homestay/mainPage/menu";
	}
	@RequestMapping(value = "/mainpage/mainview")
	public String mainview(HttpServletRequest httpServletRequest, Model model) {
		String theme1 = httpServletRequest.getParameter("theme1").toString();
		String theme_kor1 = httpServletRequest.getParameter("theme_kor1").toString();
		String theme2 = httpServletRequest.getParameter("theme2").toString();
		String theme_kor2 = httpServletRequest.getParameter("theme_kor2").toString();
		String theme3 = httpServletRequest.getParameter("theme3").toString();
		String theme_kor3 = httpServletRequest.getParameter("theme_kor3").toString();
		String location = httpServletRequest.getParameter("location").toString();
		
		model.addAttribute("theme1", theme1);
		model.addAttribute("theme2", theme2);
		model.addAttribute("theme3", theme3);
		model.addAttribute("theme_kor1", theme_kor1);
		model.addAttribute("theme_kor2", theme_kor2);
		model.addAttribute("theme_kor3", theme_kor3);
		model.addAttribute("location", location);
//		
		
		//model.addAllAttributes(httpServletRequest.getParameterMap());
		
		return "homestay/mainPage/mainView";
	}


	@RequestMapping(value = "/main")
	public String index(HttpServletRequest httpServletRequest, Model model) {

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
		String location = httpServletRequest.getParameter("location").toString();

		model.addAttribute("theme1", "theme1");
		model.addAttribute("theme2", "theme2");
		model.addAttribute("theme3", "theme3");
		model.addAttribute("theme4", "theme4");
		model.addAttribute("theme5", "theme5");
		model.addAttribute("theme6", "theme6");
		model.addAttribute("theme_kor1", "문화시설");
		model.addAttribute("theme_kor2", "축제공연행사");
		model.addAttribute("theme_kor3", "관광지");
		model.addAttribute("theme_kor4", "레포츠");
		model.addAttribute("theme_kor5", "음식");
		model.addAttribute("theme_kor6", "쇼핑");
		model.addAttribute("location", location);
		
		
		//model.addAllAttributes(httpServletRequest.getParameterMap());
		
		
		return "homestay/mainPage/index";
	}
	
	
}
