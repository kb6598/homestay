package com.homestay.korea.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homestay.korea.DTO.MemberDTO;
import com.homestay.korea.DTO.ThemePreferDTO;
import com.homestay.korea.service.IThemePreferReadService;
import com.homestay.korea.util.RelationAnalyze;

@Controller
public class InfoController {
	
	@Autowired
	IThemePreferReadService themePreferReadService;
	
	@RequestMapping(value = "/mainpage/subview")
	public String subview(HttpServletRequest httpServletRequest, Model model) {
		
		String theme = httpServletRequest.getParameter("theme").toString();
		String theme_kor = httpServletRequest.getParameter("theme_kor").toString();
		String location = httpServletRequest.getParameter("location").toString();
		
		model.addAttribute("theme_kor",theme_kor);
		model.addAttribute("theme",theme);
		model.addAttribute("location",location);
		
//		HttpSession httpSession = httpServletRequest.getSession();
//		MemberDTO member = (MemberDTO)httpSession.getAttribute("memberInfo");
		ThemePreferDTO themePreferDTO =  themePreferReadService.getThemePrefer("billp");
		RelationAnalyze relationAnalyze = new RelationAnalyze(themePreferDTO);

		List<ThemePreferDTO> themePreferDTOList = themePreferReadService.getThemePreferList();
		String idArr[] =  relationAnalyze.getMatchIds(themePreferDTOList);
		for(int i=0; i<idArr.length;i++) {
			System.out.println(idArr[i]);
		}
		//model.addAllAttributes(httpServletRequest.getParameterMap());
		
		return "homestay/mainPage/subView";
	}
}
