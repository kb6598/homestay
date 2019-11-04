package com.homestay.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IPlaceDetailDataDAO;
import com.homestay.korea.DTO.PlaceDetailDataDTO;

@Service
public class PlaceDetailDataReadService implements IPlaceDetailDataReadService {
	
	@Autowired
	private IPlaceDetailDataDAO placeDetailDataDAO;

	//메인화면에서 관광지 클릭 시, 상세페이지로 넘어가며 보여질 관광지 정보
	@Override
	public List<PlaceDetailDataDTO> readWithPlaceDetailDate(PlaceDetailDataDTO vo) throws Exception {
		
		return placeDetailDataDAO.readWithPlaceDetailDate(vo);
	}
}
