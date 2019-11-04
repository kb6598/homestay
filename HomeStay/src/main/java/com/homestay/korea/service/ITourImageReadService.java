package com.homestay.korea.service;


import java.util.List;


import com.homestay.korea.DTO.TourImageDTO;

public interface ITourImageReadService {
	
	public TourImageDTO getTourIamge(String contentid);
	
	public List<TourImageDTO> getTourImageByThemeLocation(String theme, String location, int limit);
	
	//메인화면에서 관광지 클릭 시, 상세페이지로 넘어가며 보여질 관광지 사진
	public List<TourImageDTO> readWithPlaceDetailDateImage(TourImageDTO vo) throws Exception;
	
}
