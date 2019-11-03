package com.homestay.korea.service;

import java.util.List;
import com.homestay.korea.DTO.TourImageDTO;;

public interface IContentMainService {
	public List<TourImageDTO> getTourImageByThemeLocationOrderByPlcaeCountLimit(String theme, String location, int limit);
}
