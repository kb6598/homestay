package com.homestay.korea.service;

import java.util.List;

import com.homestay.korea.DTO.JoinPlaceTourImageDTO;
import com.homestay.korea.DTO.TourImageDTO;;

public interface IContentMainService {
	
	public List<JoinPlaceTourImageDTO> getJoinPlaceTourImageDTOForIndex(String theme, String location, int start, int end);
}
