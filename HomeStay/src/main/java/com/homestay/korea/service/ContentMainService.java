package com.homestay.korea.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IJoinPlaceTourImageDAO;

import com.homestay.korea.DTO.JoinPlaceTourImageDTO;


@Service
public class ContentMainService implements IContentMainService{


	@Autowired
	private IJoinPlaceTourImageDAO joinPlaceTourImageDAO;


	@Override
	public List<JoinPlaceTourImageDTO> getJoinPlaceTourImageDTOForIndex(String theme, String location) {
		// TODO Auto-generated method stub
		
		List<JoinPlaceTourImageDTO> resultList = new ArrayList<JoinPlaceTourImageDTO>();

		resultList = joinPlaceTourImageDAO.readWithThemeLocationStartEndOrderByParm(theme, location, 0, 9, "count");

		return resultList;
	}
	



}
