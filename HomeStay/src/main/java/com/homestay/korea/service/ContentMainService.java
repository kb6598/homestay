package com.homestay.korea.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.homestay.korea.DAO.IPlaceDAO;
import com.homestay.korea.DAO.IThemePreferDAO;
import com.homestay.korea.DAO.ITourImageDAO;

public class ContentMainService implements IContentMainService{

	@Autowired
	private IThemePreferDAO themePreferDAO;
	
	@Autowired
	private ITourImageDAO tourImageDAO;
	
	@Autowired
	private IPlaceDAO placeDao;
	
	@Override
	public Map<String, String> getPlaceInfoByTheme() {
		// TODO Auto-generated method stub
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		//가져올 데이터 구조
		//contentid	createdtime	modifiedtime	theme	count	location	imageno	imageurl	contentid

		
		
		
		return resultMap;
	}

}
