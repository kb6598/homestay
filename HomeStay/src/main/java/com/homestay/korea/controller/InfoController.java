package com.homestay.korea.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homestay.korea.DTO.PlaceDetailDataDTO;
import com.homestay.korea.DTO.ThemePreferDTO;
<<<<<<< HEAD
import com.homestay.korea.DTO.TourImageDTO;
import com.homestay.korea.service.IContentMainService;
import com.homestay.korea.service.IPlaceDetailDataReadService;
=======
>>>>>>> dce1ad45229bace5168fc1f0e488d0eb95f77e1b
import com.homestay.korea.service.IThemePreferReadService;
import com.homestay.korea.service.ITourImageReadService;
import com.homestay.korea.util.RelationAnalyze;

@Controller
public class InfoController {
	
	@Autowired
	IThemePreferReadService themePreferReadService;
	
	
	@Autowired
	private IPlaceDetailDataReadService placeDetailDataReadService;
	
	@Autowired
	private ITourImageReadService tourImageReadService;
	
	
	@RequestMapping("detail")
	public String detail(PlaceDetailDataDTO vo, Model model, HttpServletRequest request) {
		
		//메인 페이지에서 관광지의 contentId받아오기
		String contentid = request.getParameter("contentid");
		
		try {

			vo.setContentid("1");
			
			//관광지 공통정보 불러오기
			List<PlaceDetailDataDTO> readWithplaceDetailData = placeDetailDataReadService.readWithPlaceDetailDate(contentid, vo);
			//관광지 이미지 불러오기
			List<TourImageDTO> readWithPlaceDetailDateImage = tourImageReadService.readWithPlaceDetailDateImage(contentid);
			
			model.addAttribute("readWithplaceDetailData", readWithplaceDetailData);
			model.addAttribute("readWithPlaceDetailDateImage", readWithPlaceDetailDateImage);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "homestay/detailContent";
	}
	
	@RequestMapping(value = "/mainpage/subview")
	public String subview(HttpServletRequest httpServletRequest, Model model) {
		
		String theme = httpServletRequest.getParameter("theme").toString();
		String theme_kor = httpServletRequest.getParameter("theme_kor").toString();
		String location = httpServletRequest.getParameter("location").toString();
		
		model.addAttribute("theme_kor",theme_kor);
		model.addAttribute("theme",theme);
		model.addAttribute("location",location);
		
		// 이미지 바인딩
		List<TourImageDTO> TourImageList = contentMainService.getTourImageByThemeLocationOrderByPlcaeCountLimit(theme, location, 9); 
		
		
		model.addAttribute("TourImageList", TourImageList);
=======
	@RequestMapping(value="/detailContent")
	public String detailContent(HttpServletRequest httpServletRequest) throws SQLException {
>>>>>>> dce1ad45229bace5168fc1f0e488d0eb95f77e1b
		
		//HttpSession httpSession = httpServletRequest.getSession();
		//MemberDTO member = (MemberDTO)httpSession.getAttribute("memberInfo");
		ThemePreferDTO themePreferDTO =  themePreferReadService.getThemePrefer("billp");
		RelationAnalyze relationAnalyze = new RelationAnalyze(themePreferDTO);

		List<ThemePreferDTO> themePreferDTOList = themePreferReadService.getThemePreferList();
		String idArr[] =  relationAnalyze.getMatchIds(themePreferDTOList);
		for(int i=0; i<idArr.length;i++) {
			System.out.println(idArr[i]);
		}
		
		return "/detailContent";
		
	}
}




