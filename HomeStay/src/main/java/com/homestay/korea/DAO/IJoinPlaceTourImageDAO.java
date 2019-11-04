package com.homestay.korea.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homestay.korea.DTO.JoinPlaceTourImageDTO;
import com.homestay.korea.DTO.TourImageDTO;

public interface IJoinPlaceTourImageDAO {
	//
	public JoinPlaceTourImageDTO readWithContentid(String contentid);
	
	//이미지가 여러개일경우 하나만 가져옴

	public ArrayList<JoinPlaceTourImageDTO> readWithThemeLocationStartEndOrderByParm(@Param("theme") String theme, 
																			@Param("location") String location,
																			@Param("start") int start,
																			@Param("end") int end, 
																			@Param("parm") String parm);
	
	public ArrayList<JoinPlaceTourImageDTO> readWithThemeStartEndOrderByParm(@Param("theme") String theme, 
			@Param("start") int start,
			@Param("end") int end, 
			@Param("parm") String parm);
	

}
