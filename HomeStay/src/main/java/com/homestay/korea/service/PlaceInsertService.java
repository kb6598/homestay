package com.homestay.korea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IPlaceDAO;
import com.homestay.korea.DTO.PlaceDTO;

@Service
public class PlaceInsertService implements IPlaceInsertService {

	
	@Autowired
	private IPlaceDAO placeDao;
	
	@Override
	public void insertPlaceData(PlaceDTO dto) {
		placeDao.insertWithDTO(dto);
	}
}
