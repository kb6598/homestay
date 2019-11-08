package com.homestay.korea.service;

import java.util.List;

import com.homestay.korea.DTO.PlaceDetailDataDTO;

public interface IPlaceDetailDataReadService {

	//메인화면에서 관광지 클릭 시, 상세페이지로 넘어가며 보여질 관광지 정보
	public List<PlaceDetailDataDTO> readWithPlaceDetailData(PlaceDetailDataDTO vo) throws Exception;
}
