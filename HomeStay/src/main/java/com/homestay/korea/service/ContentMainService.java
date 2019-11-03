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
public class ContentMainService implements IContentMainService{


	@Autowired
	private ITourImageDAO tourImageDAO;
	
	@Autowired
	private IPlaceDAO placeDao;

	@Override
	public List<TourImageDTO> getTourImageByThemeLocationOrderByPlcaeCountLimit(String theme, String location, int limit) {
		// TODO Auto-generated method stub
		
		List<TourImageDTO> resultList = new ArrayList<TourImageDTO>();
		TourImageDTO tmpDTO;
		List<PlaceDTO> placeList = placeDao.readWithThemeLocationOrderByCount(theme, location, limit);
		for(PlaceDTO place : placeList) {
			tmpDTO = new TourImageDTO();			
			tmpDTO = tourImageDAO.readWithContentid(place.getContentid().toString());
			resultList.add(tmpDTO);
		}		
		
		return resultList;
	}
	



}
