package com.homestay.korea.DAO;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;


import com.homestay.korea.DTO.TourImageDTO;

public interface ITourImageDAO {
	
	public TourImageDTO readWithContentid(String contentid);
	//
	public ArrayList<TourImageDTO> readWithThemeLocationLimitDesc(@Param("theme") String theme, @Param("location") String location, @Param("limit") int limit);
	
}
