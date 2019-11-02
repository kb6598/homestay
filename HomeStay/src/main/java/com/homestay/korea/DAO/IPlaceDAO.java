package com.homestay.korea.DAO;


import com.homestay.korea.DTO.PlaceDTO;

public interface IPlaceDAO {
	
	public PlaceDTO readWithContentid(String contentid);
	
}
