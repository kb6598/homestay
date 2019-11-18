package com.homestay.korea.util;

import java.io.IOException;
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
 * 공통정보 데이터 클래스입니다.
 */
@Component
public class CommonDetailData {

	private Api commonData; //공통정보
	private String[] commonTempStrArr = {"<overview>","<addr1>","<tel>","<telname>","<title>"};
	@Autowired
	private IPlaceDetailDataDAO placeDetailDao;
	private PlaceDetailDataDTO placeDetailDataDTO; 
	private Map<String,String> commonDataUriMap;
	
	public CommonDetailData() {
		this.commonDataUriMap = new HashMap<>();
		commonDataUriMap.put("overviewYN", "Y");
		commonDataUriMap.put("defaultYN", "Y");
		commonDataUriMap.put("addrinfoYN", "Y");
		this.placeDetailDataDTO = new PlaceDetailDataDTO();
	}
	
	public Api getCommonData() {
		return commonData;
	}

	public void setCommonData(Api commonData) {
		this.commonData = commonData;
	}

	public IPlaceDetailDataDAO getPlaceDetailDao() {
		return placeDetailDao;
	}

	public void setPlaceDetailDao(IPlaceDetailDataDAO placeDetailDao) {
		this.placeDetailDao = placeDetailDao;
	}

	public Map<String, String> getCommonDataUriMap() {
		return commonDataUriMap;
	}

	public void setCommonDataUriMap(Map<String, String> commonDataUriMap) {
		this.commonDataUriMap = commonDataUriMap;
	}
	
	public PlaceDetailDataDTO getPlaceDetailDataDTO() {
		return placeDetailDataDTO;
	}

	public void setPlaceDetailDataDTO(PlaceDetailDataDTO placeDetailDataDTO) {
		this.placeDetailDataDTO = placeDetailDataDTO;
	}

	//place_detailData테이블에 알맞게 처리된 상세관광지정보를 저장
	public void storeSettedData(String totalXmlStr, String contentId) throws LimitedRequestException, NotOkResponseException {
		
		TagInfo tagInfo = new TagInfo();
		
		if(commonDataUriMap.get("contentId") != null) {
			commonDataUriMap.replace("contentId", contentId); //commonDataUriMap을 객체하나로만 사용할려고 확인작업
		}else {
			commonDataUriMap.put("contentId", contentId);
		}
		try {
			commonData = new Api("detailCommon", commonDataUriMap, ServiceKey.TOTAL_SERVICEKEY[7]);
		}catch(IOException e) {
			e.printStackTrace();
		}
		String resultCommonDataXmlStr = commonData.getResultXmlStr();
		String resultCodeStr = XmlString.extractXmlValue("<resultCode>",resultCommonDataXmlStr);
		if(!resultCodeStr.equals("0000")) {
			if(resultCodeStr.equals("0022"))
					throw new LimitedRequestException();
			throw new NotOkResponseException();
		}
		if(resultCommonDataXmlStr.contains("<item>")) {
			String overviewData = XmlString.extractXmlValue("<overview>",resultCommonDataXmlStr);
			String addrData = XmlString.extractXmlValue("<addr1>",resultCommonDataXmlStr);
			String telData = XmlString.extractXmlValue("<tel>",resultCommonDataXmlStr);
			String telnameData = XmlString.extractXmlValue("<telname>",resultCommonDataXmlStr);
			String title = XmlString.extractXmlValue("<title>",resultCommonDataXmlStr);
			System.out.println("--------------------------------- 공통 정보 시작 ---------------------------------");
			
			for(int idx=0; idx<commonTempStrArr.length; idx++) {
				if(!XmlString.extractXmlValue(commonTempStrArr[idx],resultCommonDataXmlStr).equals("noTag")) {
					placeDetailDataDTO.setContent_category(tagInfo.commonTag.get(commonTempStrArr[idx]));
					placeDetailDataDTO.setContent(XmlString.extractXmlValue(commonTempStrArr[idx],resultCommonDataXmlStr));
					placeDetailDataDTO.setContentid(contentId);
					placeDetailDao.insert(placeDetailDataDTO); //공통정보db에 저장
				}
			}
			
			System.out.println("개요:" + overviewData);
			System.out.println("주소:" + addrData);
			System.out.println("전화번호:" + telData);
			System.out.println("전화번호 명:"+telnameData);
			System.out.println("제목:"+title);
			System.out.println("--------------------------------- 공통 정보 끝 ----------------------------------");
		}
		
	}
}











