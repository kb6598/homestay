package com.homestay.korea.service;


import java.util.List;


import com.homestay.korea.DTO.TourImageDTO;

public interface ITourImageReadService {
	
	public TourImageDTO getTourIamge(String contentid);
	
	public List<TourImageDTO> getTourImageByThemeLocation(String theme, String location, int limit);
	
}
