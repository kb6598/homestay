package com.homestay.korea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.ITourImageDAO;

@Service
public class TourImageDeleteService  implements ITourImageDeleteService {

	@Autowired
	private ITourImageDAO imageDao;
	
	@Override
	public boolean isDeletedTourImages(String contentid) {
		if(imageDao.deleteImageWithContentid(contentid) != 0)
			return true;
		return false;
	}
	
}
