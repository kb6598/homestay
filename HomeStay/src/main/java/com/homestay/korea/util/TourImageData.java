package com.homestay.korea.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homestay.korea.DAO.ITourImageDAO;
import com.homestay.korea.DTO.TourImageDTO;
import com.homestay.korea.common.ServiceKey;
import com.homestay.korea.exception.LimitedRequestException;
import com.homestay.korea.exception.NotOkResponseException;

/*
 * 관광지 이미지 클래스입니다.
 */
@Component
public class TourImageData {
	
	@Autowired
	private ITourImageDAO tourImageDao;
	private TourImageDTO tourImageDTO; 
	private Map<String,String> detailImageUriMap;
	
	public TourImageData() {
		this.detailImageUriMap = new HashMap<>();
		detailImageUriMap.put("ImageYN","Y");
		this.tourImageDTO = new TourImageDTO();
	}
	
	public ITourImageDAO getTourImageDao() {
		return tourImageDao;
	}

	public void setTourImageDao(ITourImageDAO tourImageDao) {
		this.tourImageDao = tourImageDao;
	}

	public TourImageDTO getTourImageDTO() {
		return tourImageDTO;
	}

	public void setTourImageDTO(TourImageDTO tourImageDTO) {
		this.tourImageDTO = tourImageDTO;
	}

	public Map<String, String> getDetailImageUriMap() {
		return detailImageUriMap;
	}

	public void setDetailImageUriMap(Map<String, String> detailImageUriMap) {
		this.detailImageUriMap = detailImageUriMap;
	}

	public void storeTourImageData(String totalXmlStr,String contentId) 
			throws LimitedRequestException, NotOkResponseException {
		
		XmlString xmlStr = new XmlString();
		detailImageUriMap.put("contentId", contentId);
		Map<String,String> eachImageUrl=xmlStr.extractXmlNodeAndValue(ApiUrl.makeAPIUri("detailImage", 
				detailImageUriMap, ServiceKey.TOTAL_SERVICEKEY[7]),"imageInfo");
		System.out.println("--------------------------------- 추가이미지 정보 시작 ---------------------------------");
		if(!eachImageUrl.isEmpty()) {
			for(Map.Entry<String,String> entry : eachImageUrl.entrySet()) {
				String nodeName = entry.getKey();
				String value = entry.getValue();
				if(nodeName.startsWith("originimgurl")) {
					tourImageDTO.setContentid(contentId);
					tourImageDTO.setImageurl(value);
					tourImageDao.insertSingleTourImageRecord(tourImageDTO); //이미지 정보 db에저장
					System.out.println("키값:" + nodeName + ", value값: " + value);
				}
			}
		}
		System.out.println("--------------------------------- 추가이미지 정보 끝 ----------------------------------");
		System.out.println();
		System.out.println();
	}
	
}
