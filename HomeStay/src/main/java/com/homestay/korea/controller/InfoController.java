package com.homestay.korea.controller;

import java.sql.SQLException;
<<<<<<< HEAD
=======
import java.util.Iterator;
>>>>>>> a9a0d21c4362c8723d513a6d42eceb316cf687ff
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homestay.korea.DTO.MemberDTO;
import com.homestay.korea.DTO.MemberLogDTO;
import com.homestay.korea.DTO.PlaceDetailDataDTO;
import com.homestay.korea.DTO.ThemePreferDTO;
import com.homestay.korea.DTO.TourImageDTO;
import com.homestay.korea.service.IContentMainService;
import com.homestay.korea.service.IMemberLogService;
import com.homestay.korea.service.IMemberReadService;
import com.homestay.korea.service.IPlaceDetailDataReadService;
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
	
	@Autowired
	public IMemberLogService memberLogService;
	
	@Autowired
	private IMemberReadService memberReadService;
	
	
	//상세 페이지로 이동
	@RequestMapping(value="/detailContent", method = RequestMethod.GET)
	public String detailContent(PlaceDetailDataDTO placeDetailDataDTO, TourImageDTO tourImageDTO, Model model, HttpServletRequest request, HttpSession session, MemberLogDTO memberLogDTO) throws SQLException {
		
		//메인 페이지에서 관광지의 contentId받아오기
		String contentid = request.getParameter("contentid");
		
		if(session.getAttribute("memberInfo") == null) 
		{
			model.addAttribute("memberinfo",session.getAttribute("memberInfo"));
		}else {
			MemberDTO memberInfo = (MemberDTO) session.getAttribute("memberInfo");
			memberLogDTO.setId(memberInfo.getId());
			memberLogDTO.setContentId(contentid);
			memberLogService.insertMemberLog(memberLogDTO);
		}
		
		try {
			//관광지 공통정보 + 관광지 이미지
			placeDetailDataDTO.setContentid(contentid);
			tourImageDTO.setContentid(contentid);
			
			//메인에서 값 넘겨주기 전까지는 해당 소스 사용
			//placeDetailDataDTO.setContentid("1");
			//tourImageDTO.setContentid("1");
			
			//User-Based Collaborative Filtering
			//HttpSession httpSession = httpServletRequest.getSession();
			//MemberDTO member = (MemberDTO)httpSession.getAttribute("memberInfo");
			


			if(session.getAttribute("memberInfo") != null) {
				
				/*
				1. 로그인한 아이디의 성별,연령대,동반인을 가져옴

				2. Select memberID from member_log where contentID = "클릭한 컨텐츠아이디"
					and memberID IN (Select memberID
							from member
							where gender = "세션성별"
							and age = "세션연령대" and "세션동반인")  해서 memberID리스트 가져옴

				3. Select * from Theme_prefer where id In memberID;    Theme_prefer DTO 리스트를 가져옴
				 */
				
				MemberDTO memberInfo = (MemberDTO)session.getAttribute("memberInfo");
				String gender = memberInfo.getGender();
				String age = memberInfo.getAge();
				String companion = memberInfo.getCompanion();
				
				List<String> relationIds =  memberReadService.getRelationId(contentid, gender, age, companion);
				List<ThemePreferDTO> themeRelationPreferDTOList = themePreferReadService.getRelationThemePreferList(relationIds);
				
				ThemePreferDTO themePreferDTO =  themePreferReadService.getThemePrefer(memberInfo.getId());
				RelationAnalyze relationAnalyze = new RelationAnalyze(themePreferDTO);
				
				List<String> ids =  relationAnalyze.getMatchIds(themeRelationPreferDTOList);
				for(int i=0; i<ids.size(); i++) 
				{
					System.out.println(ids.get(i));
				}
				
				if(ids.size() > 0) {
					ids.add(memberInfo.getId());
				//컨텐츠 아이디 가져오기
					List<String> contentIds = memberLogService.readContentIdWithIds(ids);
					for(String contentId : contentIds) {
						System.out.println(contentId);
					}
					
					//이미지 및 제목 가져오기
					List<String> titles = placeDetailDataReadService.readTitles(contentIds);
					List<TourImageDTO> tourImageDTOs = tourImageReadService.readWithContentIds(contentIds);
					
					//현재보고있는 관광지의 정보는 삭제
					Iterator<String> iterTitle = titles.iterator();
					Iterator<TourImageDTO> iter = tourImageDTOs.iterator();
					while (iter.hasNext()) {
						iterTitle.hasNext();
						TourImageDTO t = iter.next();
						String s = iterTitle.next();
						if (t.getContentid().equals(contentid)) {
							iter.remove();
							iterTitle.remove();
						}
					}
					//콘솔로 test
					for(TourImageDTO tourImageDTO2 : tourImageDTOs) {
						System.out.println(tourImageDTO2.getImageurl());
						System.out.println(tourImageDTO2.getContentid());
					}
					for(String title : titles) {
						System.out.println(title);
					}
				
					model.addAttribute("titles", titles);
					model.addAttribute("tourImageDTOs", tourImageDTOs);
				}
			}
			
			//관광지 공통정보 불러오기
			model.addAttribute("readWithPlaceDetailData", placeDetailDataReadService.readWithPlaceDetailData(placeDetailDataDTO));
			//관광지 이미지정보 불러오기
			model.addAttribute("readWithPlaceDetailDataImage", tourImageReadService.readWithPlaceDetailDataImage(tourImageDTO));
			//contentId
			model.addAttribute("contentid", contentid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "homestay/detailContent";
	}
}
