package com.homestay.korea.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homestay.korea.DTO.TourImageDTO;

public interface ITourImageDAO {
	
	public TourImageDTO readWithContentid(String contentid);
	//조건 theme, location, 갯수 limit	
	public ArrayList<TourImageDTO> readWithThemeLimit(@Param("theme") String theme, @Param("limit") int limit);
	
	//메인화면에서 관광지 클릭 시, 상세페이지로 넘어가며 보여질 관광지 사진
	public List<TourImageDTO> readWithPlaceDetailDateImage(String contentid);
}
