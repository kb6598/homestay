package com.homestay.korea.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homestay.korea.HomeController;
import com.homestay.korea.DTO.JoinPlaceTourImageDTO;
import com.homestay.korea.DTO.MemberDTO;
import com.homestay.korea.DTO.ThemePreferDTO;
import com.homestay.korea.DTO.TourImageDTO;
import com.homestay.korea.service.IContentMainService;
import com.homestay.korea.service.IThemePreferReadService;


@Controller
public class IndexController {
	
@Autowired
private IContentMainService contentMainService;

@Autowired
private IThemePreferReadService themePreferReadService;


	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	

	
	
	
	// TOP View 사진 3개만 보여주는 페이지
	@RequestMapping(value = "/mainpage/topview")
	public String topview(HttpServletRequest httpServletRequest, Model model) {
		//이미지 바인딩
		String[] images = new String[] {
				"/resources/mainContent/1.jpg",
				"/resources/mainContent/2.jpg",
				"/resources/mainContent/3.jpg",
				"/resources/mainContent/4.jpg"				
		};
		
		model.addAttribute("images",images);

		return "homestay/mainPage/topView";
	}
	
	
	
	@RequestMapping(value = "/mainpage/menu", method=RequestMethod.GET)
	public String menu(HttpServletRequest httpServletRequest, Model model) {
		//get으로 받은 location값을 모델로 넘겨줌
		String location = httpServletRequest.getParameter("location").toString();
		model.addAttribute("location",location);
		
		
		return "homestay/mainPage/menu";
	}
	@RequestMapping(value = "/mainpage/mainview", method= {RequestMethod.POST,RequestMethod.GET})
	public String mainview(HttpServletRequest httpServletRequest, Model model) {
		// 파라미터 전달
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
		
		//---------TourImage 바인딩
		
		List<JoinPlaceTourImageDTO> joinPlaceTourImageDTO1 = contentMainService.getJoinPlaceTourImageDTOForIndex(theme1, location,0,6);
		List<JoinPlaceTourImageDTO> joinPlaceTourImageDTO2 = contentMainService.getJoinPlaceTourImageDTOForIndex(theme2, location,0,6);
		List<JoinPlaceTourImageDTO> joinPlaceTourImageDTO3 = contentMainService.getJoinPlaceTourImageDTOForIndex(theme3, location,0,6);
		
		
		model.addAttribute("joinPlaceTourImageDTO1", joinPlaceTourImageDTO1);
		model.addAttribute("joinPlaceTourImageDTO2", joinPlaceTourImageDTO2);
		model.addAttribute("joinPlaceTourImageDTO3", joinPlaceTourImageDTO3);

		
		return "homestay/mainPage/mainView";
	}

	@RequestMapping(value = "/mainpage/subview")
	public String subview(HttpServletRequest httpServletRequest, Model model) {
		// 파라미터 전달
		String theme = httpServletRequest.getParameter("theme").toString();
		String theme_kor = httpServletRequest.getParameter("theme_kor").toString();
		String location = httpServletRequest.getParameter("location").toString();
		model.addAttribute("theme_kor",theme_kor);
		model.addAttribute("theme",theme);
		model.addAttribute("location",location);
		

		// 이미지 바인딩
		List<JoinPlaceTourImageDTO> joinPlaceTourImageDTO = contentMainService.getJoinPlaceTourImageDTOForIndex(theme, location,0,9);		
		model.addAttribute("joinPlaceTourImageDTO", joinPlaceTourImageDTO);
		
		
		return "homestay/mainPage/subView";
	}
	
	



	
	
	@RequestMapping(value = "/main")
	public String index(HttpServletRequest httpServletRequest, Model model, HttpSession session) throws UnsupportedEncodingException {


		
		

		
		//get으로 전달 받는 파라미터가 없다면  location 값 전체로 설정  
		//----------- get 으로 location값이 없으면 전체로 설정
		String location ="";
		if(httpServletRequest.getParameter("location") != null) {
			location = httpServletRequest.getParameter("location").toString();
		}else {
			location = URLEncoder.encode("전체", "UTF-8");
		}
		model.addAttribute("location", location);
		//--------------

		

		if(session.getAttribute("memberInfo") != null) {
			MemberDTO member = (MemberDTO) session.getAttribute("memberInfo");
			
			ThemePreferDTO themePreferDTO = themePreferReadService.getThemePrefer(member.getId());
			logger.info("--------------------------------");
			logger.info("--------------------------------");
			logger.info(themePreferDTO.toString());
			logger.info("--------------------------------");
			logger.info("--------------------------------");
			
		
			//-- value 값으로 map 정렬 
			//--- 선호도 순으로 테마를 정렬
			Map<String, Double> map = new HashMap<>();
			//전체  관광지  문화시설  축제공연행사  여행코스  레포츠  숙박  쇼핑  음식점
			map.put("문화시설",themePreferDTO.getCult_facil());			
			map.put("음식점",themePreferDTO.getDining());
			map.put("축제공연행사",themePreferDTO.getEvent());
			map.put("레포츠",themePreferDTO.getLeports());
			map.put("쇼핑",themePreferDTO.getShopping());
			map.put("관광지",themePreferDTO.getTour_attr());
			
			List<String> keySetList = new ArrayList<>(map.keySet());
			Collections.sort(keySetList, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return map.get(o2).compareTo(map.get(o1));
				}
			});
//			for(String key : keySetList) {
//				logger.info("--------------------------------");
//				logger.info("--------------------------------");
//	            logger.info(String.format("Key : %s, Value : %s", key, map.get(key)));
//				logger.info("--------------------------------");
//				logger.info("--------------------------------");
//	        }
			//----- 파라미터 전달
			String[] themeHeader = new String[]{"theme1",	"theme2","theme3","theme4","theme5","theme6"};
			String[] theme_korHeader = new String[]{"theme_kor1", "theme_kor2","theme_kor3","theme_kor4","theme_kor5","theme_kor6"};
			
			int index = 0;
			for(String key : keySetList) {
				model.addAttribute(themeHeader[index], key);
				model.addAttribute(theme_korHeader[index], URLEncoder.encode(key, "UTF-8"));
				index++;
			}
			
			


			
		}else {
			



			//----------로그인 아닐때 페이지
			// 파라미터 전달
			model.addAttribute("theme1", "문화시설");
			model.addAttribute("theme2", "축제공연행사");
			model.addAttribute("theme3", "관광지");
			model.addAttribute("theme4", "레포츠");
			model.addAttribute("theme5", "음식점");
			model.addAttribute("theme6", "쇼핑");
			//URLEncoder.encode("문화시설", "UTF-8")) -> 한글을 utf-8 url 값으로 변환
			model.addAttribute("theme_kor1", URLEncoder.encode("문화시설", "UTF-8"));
			model.addAttribute("theme_kor2", URLEncoder.encode("축제공연행사", "UTF-8"));
			model.addAttribute("theme_kor3", URLEncoder.encode("관광지", "UTF-8"));
			model.addAttribute("theme_kor4", URLEncoder.encode("레포츠", "UTF-8"));
			model.addAttribute("theme_kor5", URLEncoder.encode("음식점", "UTF-8"));
			model.addAttribute("theme_kor6", URLEncoder.encode("쇼핑", "UTF-8"));
			

		}
			

		
		return "homestay/mainPage/index";
	}
	
	
}
