package com.homestay.korea.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.homestay.korea.DAO.IPlaceDAO;
import com.homestay.korea.DAO.ITourImageDAO;
import com.homestay.korea.DTO.PlaceDTO;
import com.homestay.korea.DTO.TourImageDTO;

@Service
public class TourImageReadServiceImpl implements ITourImageReadService {
	
	@Autowired
	private ITourImageDAO tourImageDAO;

	@Override
	public TourImageDTO getTourIamge(String contentid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<TourImageDTO> getTourImageByThemeLocation(java.lang.String theme, java.lang.String location,
			int limit) {
		// TODO Auto-generated method stub
		return null;
	}




	
	
	
	
}




















