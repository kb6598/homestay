package com.homestay.korea.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homestay.korea.DAO.IPlaceDetailDataDAO;
import com.homestay.korea.DTO.PlaceDetailDataDTO;
import com.homestay.korea.common.ServiceKey;
import com.homestay.korea.common.TagInfo;
import com.homestay.korea.exception.LimitedRequestException;
import com.homestay.korea.exception.NotOkResponseException;

/*
 * 세부정보 관련한 클래스입니다.
 */
@Component
public class DetailData {
	
	private PlaceDetailDataDTO placeDetailDataDTO;
	@Autowired
	private IPlaceDetailDataDAO placeDetailDao;
	private Map<String,String>  introDataUriMap;
	
	public DetailData() {
		this.introDataUriMap = new HashMap<>();
		this.placeDetailDataDTO = new PlaceDetailDataDTO();
	}
	
	public PlaceDetailDataDTO getPlaceDetailDataDTO() {
		return placeDetailDataDTO;
	}

	public void setPlaceDetailDataDTO(PlaceDetailDataDTO placeDetailDataDTO) {
		this.placeDetailDataDTO = placeDetailDataDTO;
	}

	public IPlaceDetailDataDAO getPlaceDetailDao() {
		return placeDetailDao;
	}

	public void setPlaceDetailDao(IPlaceDetailDataDAO placeDetailDao) {
		this.placeDetailDao = placeDetailDao;
	}

	public Map<String, String> getIntroDataUriMap() {
		return introDataUriMap;
	}

	public void setIntroDataUriMap(Map<String, String> introDataUriMap) {
		this.introDataUriMap = introDataUriMap;
	}

	public void storeSettedData(String totalXmlStr,String contentId,String contentTypeId) 
			throws LimitedRequestException, NotOkResponseException {
		
		XmlString xmlStr = new XmlString();
		TagInfo tagInfo = new TagInfo();
		
		introDataUriMap.put("contentTypeId", contentTypeId); //갱신해야함
		introDataUriMap.put("contentId", contentId); //갱신해야함
		Map<String,String> eachNodeNames=xmlStr.extractXmlNodeAndValue(ApiUrl.makeAPIUri("detailIntro", 
				introDataUriMap,ServiceKey.TOTAL_SERVICEKEY[7]), "detailInfo");
		Map<String,String> resultDetailMap = new HashMap<>(); //DB에 저장해야하는 파싱된정보
		System.out.println("--------------------------------- 상세 정보 시작 ---------------------------------");
		for(Map.Entry<String,String> entry : eachNodeNames.entrySet()){
			String key = tagInfo.detailIntroTag.get(entry.getKey());
			if(key == null) {
				continue;
			}
			resultDetailMap.put(key, entry.getValue());
			placeDetailDataDTO.setContent_category(key);
			placeDetailDataDTO.setContent(entry.getValue()); 
			placeDetailDataDTO.setContentid(contentId);
			placeDetailDao.insert(placeDetailDataDTO); //상세정보db에 저장
			System.out.println("상세정보 키값:" + key + ", 상세정보 value값:" + entry.getValue());
		}
		System.out.println("--------------------------------- 상세 정보 끝 ----------------------------------");
		
	}
}

















