package com.homestay.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.ITourImageDAO;
import com.homestay.korea.DTO.TourImageDTO;

@Service
public class TourImageReadServiceImpl implements ITourImageReadService {
	
	@Autowired
	private ITourImageDAO tourImageDAO;

	@Override
	public TourImageDTO getTourIamge(String contentid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<TourImageDTO> getTourImageByThemeLocation(java.lang.String theme, java.lang.String location,
			int limit) {
		// TODO Auto-generated method stub
		return null;
	}


	//메인화면에서 관광지 클릭 시, 상세페이지로 넘어가며 보여질 관광지 사진
	@Override
	public List<TourImageDTO> readWithPlaceDetailDataImage(TourImageDTO vo) throws Exception {
		
		return tourImageDAO.readWithPlaceDetailDataImage(vo);
	}


	@Override
	public List<TourImageDTO> readWithContentIds(List<String> contentIds) {
		return tourImageDAO.readWithContentIds(contentIds);
	}
}




















