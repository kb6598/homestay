package com.homestay.korea.DAO;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;


import com.homestay.korea.DTO.TourImageDTO;

public interface ITourImageDAO {
	
	public TourImageDTO readWithContentid(String contentid);
	//조건 theme, location, 갯수 limit	
	public ArrayList<TourImageDTO> readWithThemeLimit(@Param("theme") String theme, @Param("limit") int limit);
}
