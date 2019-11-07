package com.homestay.korea.service;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IJoinPlaceTourImageDAO;
import com.homestay.korea.DAO.IPlaceDetailDataDAO;
import com.homestay.korea.DTO.JoinPlaceTourImageDTO;
import com.homestay.korea.DTO.PlaceDetailDataDTO;


@Service
public class ContentMainService implements IContentMainService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private IJoinPlaceTourImageDAO joinPlaceTourImageDAO;


	@Autowired
	private IPlaceDetailDataDAO placeDetailDataDAO;

	@Override
	public List<JoinPlaceTourImageDTO> getJoinPlaceTourImageDTOForIndex(String theme, String location, int start, int end) {
		// TODO Auto-generated method stub
		
		List<JoinPlaceTourImageDTO> resultList = new ArrayList<JoinPlaceTourImageDTO>();
		if(location.equals("전체")) {
			resultList = joinPlaceTourImageDAO.readWithThemeStartEndOrderByParm(theme, start, end, "count");
		}else {
			resultList = joinPlaceTourImageDAO.readWithThemeLocationStartEndOrderByParm(theme, location, start, end, "count");
		}

		

		return resultList;
	}



	
	@Override
	public List<String> getTitleByListJoinPlaceTourImageDTO(List<JoinPlaceTourImageDTO> list) {
		// TODO Auto-generated method stub
		List<String> resultList = new ArrayList<String>();
		PlaceDetailDataDTO placeDetailDataDTO = new PlaceDetailDataDTO();
		for(JoinPlaceTourImageDTO dto : list) {
			logger.info(dto.toString());
			placeDetailDataDTO.setContentid(dto.getContentid());
			placeDetailDataDTO.setContent_category("제목");
			try {
				resultList.add(placeDetailDataDAO.readWithPlaceDetailDataContent_value(placeDetailDataDTO).getContentid());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				resultList.add("제목없음");
			}
			
		}
		
		
		return resultList;
	}






}
