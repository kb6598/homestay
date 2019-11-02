package com.homestay.korea.DAO;


import java.util.ArrayList;

import com.homestay.korea.DTO.PlaceDTO;

public interface IPlaceDAO {
	
	public PlaceDTO readWithContentid(String contentid);
	//
	public ArrayList<PlaceDTO> readWithThemeLimitDesc(String theme,int limit);
	
}
