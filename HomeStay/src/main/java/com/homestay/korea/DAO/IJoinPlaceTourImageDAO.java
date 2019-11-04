package com.homestay.korea.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homestay.korea.DTO.JoinPlaceTourImage;
import com.homestay.korea.DTO.TourImageDTO;

public interface IJoinPlaceTourImageDAO {
	//
	public JoinPlaceTourImage readWithContentid(String contentid);
	
	//조건 theme, 갯수 limit
//	SELECT place.contentid as contentid, createdtime, modifiedtime, theme, count, location, imageurl, imageno 
//	FROM place, tour_image 
//	WHERE place.contentid = tour_image.contentid 
//        AND place.theme = #{theme}
//        AND place.location = #{location}
//        Order BY #{par}
//        limit #{start}, #{end}
	public ArrayList<JoinPlaceTourImage> readWithThemeLocationStartEndOrderByParm(@Param("theme") String theme, 
																			@Param("location") String location,
																			@Param("start") int start,
																			@Param("end") int end, 
																			@Param("parm") String parm);
	

}
