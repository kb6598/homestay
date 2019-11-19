package com.homestay.korea.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IPlaceDetailDataDAO;
import com.homestay.korea.DTO.PlaceDetailDataDTO;

@Service
public class PlaceDetailDataReadService implements IPlaceDetailDataReadService {
	
	@Autowired
	private IPlaceDetailDataDAO placeDetailDataDAO;

	//메인화면에서 관광지 클릭 시, 상세페이지로 넘어가며 보여질 관광지 정보
	@Override
	public List<PlaceDetailDataDTO> readWithPlaceDetailData(PlaceDetailDataDTO vo) throws Exception {	
		return placeDetailDataDAO.readWithPlaceDetailData(vo);
	}

	@Override
	public List<PlaceDetailDataDTO> readWithContentId(String contentId) throws Exception {
		return placeDetailDataDAO.readDetailData(contentId);
	}

	@Override
	public List<String> readTitles(List<String> contentIds) {
		// TODO Auto-generated method stub
		List<String> Titles = new ArrayList<String>();
		for(String contentId : contentIds) {
			Titles.add(placeDetailDataDAO.readTitles(contentId));
		}
		return Titles;
	}
	
	
}
