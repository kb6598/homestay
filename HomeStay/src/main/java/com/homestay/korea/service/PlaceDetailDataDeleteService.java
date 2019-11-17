package com.homestay.korea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IPlaceDetailDataDAO;

@Service
public class PlaceDetailDataDeleteService implements IPlaceDetailDataDeleteService {

	@Autowired
	private IPlaceDetailDataDAO placeDetailDataDao;
	
	@Override
	public boolean isDeletedPlaceDetailData(String contentId) {
		if(placeDetailDataDao.deleteDetailData(contentId) != 0) {
			return true;
		}
		return false;
	}
}
