package com.homestay.korea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homestay.korea.DAO.IPlaceDAO;
import com.homestay.korea.DAO.IPlaceDetailDataDAO;
import com.homestay.korea.DAO.ITourImageDAO;

/*
 * Data scheduling과 관련있는 클래스입니다.
 */
@Service
public class TourDataSchedulingService {
	
	@Autowired
	private IPlaceDAO placeDao;
	
	@Autowired
	private IPlaceDetailDataDAO placeDetailDataDao;
	
	@Autowired
	private ITourImageDAO tourImageDao;
	
	@Transactional
	public boolean deleteTourDataForScheduling(String contentId) {
		
		if(placeDao.deletePlaceData(contentId) == 0)
			return false;
		
		if(placeDetailDataDao.deleteDetailData(contentId) == 0)
			return false;
		
		if(tourImageDao.deleteImageWithContentid(contentId) == 0)
			return false;
		
		return true;
	}
	
}

















