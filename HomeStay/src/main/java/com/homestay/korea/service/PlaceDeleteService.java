package com.homestay.korea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IPlaceDAO;

@Service
public class PlaceDeleteService implements IPlaceDeleteService {

	@Autowired
	private IPlaceDAO placeDao;
	
	@Override
	public boolean isDeletedPlaceData(String contentId) {
		if(placeDao.deletePlaceData(contentId) != 0) {
			return true;
		}
		return false;
	}
}
