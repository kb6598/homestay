package com.homestay.korea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IPlaceDetailDataDAO;
import com.homestay.korea.DTO.PlaceDetailDataDTO;

@Service
public class PlaceDetailDataInsertService implements IPlaceDetailDataInsertService {

	
	@Autowired
	private IPlaceDetailDataDAO placeDetailDataDao;
	
	@Override
	public void insertDetailData(PlaceDetailDataDTO dto) {
		placeDetailDataDao.insert(dto);
	}
}
