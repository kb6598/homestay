package com.homestay.korea.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homestay.korea.DAO.IPlaceDAO;
import com.homestay.korea.DAO.ITourImageDAO;
import com.homestay.korea.DTO.PlaceDTO;
import com.homestay.korea.DTO.TourImageDTO;
import com.homestay.korea.common.TagInfo;

/*
 * 지역정보 관련한 클래스입니다.
 */
@Component
public class AreaBasedData {
	
	private PlaceDTO placeDTO;
	
	@Autowired
	private IPlaceDAO placeDao;
	
	private TourImageDTO tourImageDTO;
	
	@Autowired
	private ITourImageDAO tourImageDao;
	
	
	
	public AreaBasedData() {
		this.placeDTO = new PlaceDTO();
		this.tourImageDTO = new TourImageDTO();
	}

	public PlaceDTO getPlaceDTO() {
		return placeDTO;
	}

	public void setPlaceDTO(PlaceDTO placeDTO) {
		this.placeDTO = placeDTO;
	} 
	
	public IPlaceDAO getPlaceDao() {
		return placeDao;
	}

	public void setPlaceDao(IPlaceDAO placeDao) {
		this.placeDao = placeDao;
	}
	
	public TourImageDTO getTourImageDTO() {
		return tourImageDTO;
	}

	public void setTourImageDTO(TourImageDTO tourImageDTO) {
		this.tourImageDTO = tourImageDTO;
	}

	public ITourImageDAO getTourImageDao() {
		return tourImageDao;
	}

	public void setTourImageDao(ITourImageDAO tourImageDao) {
		this.tourImageDao = tourImageDao;
	}

	//place테이블에 알맞게 처리된 기역기반 관광지정보를 저장
	public void storeSettedData(String totalXmlStr) {
		
		TagInfo tagInfo = new TagInfo();
		
		//공통정보에서 가져오는 태그들
		//<areacode>,<contentid>,<createdtime>,<modifiedtime>,<contenttypeid>,<firstimage>,<mapx>,<mapy>
		String resultAreaCode = XmlString.extractXmlValue("<areacode>",totalXmlStr); 
		String korAreaName = tagInfo.areaCodeTag.get(resultAreaCode); //db에 넣어야함
		String resultContentId = XmlString.extractXmlValue("<contentid>",totalXmlStr); //파싱 필요없음
		String resultCTime = XmlString.extractXmlValue("<createdtime>",totalXmlStr); //파싱처리해야함
		String resultMTime = XmlString.extractXmlValue("<modifiedtime>",totalXmlStr); //파싱처리해야함
		String resultTypeId = XmlString.extractXmlValue("<contenttypeid>",totalXmlStr); //파싱처리해야함
		String korTheme = tagInfo.themeTag.get(resultTypeId); //db에 넣어야함
		String resultFirstImage = XmlString.extractXmlValue("<firstimage>",totalXmlStr); //원본이미지(없을 수도 있음)
		String resultXLocation = XmlString.extractXmlValue("<mapx>",totalXmlStr);
		String resultYLocation = XmlString.extractXmlValue("<mapy>",totalXmlStr);
		
		System.out.println("--------------------------------- 지역 정보 시작 ---------------------------------");
		placeDTO.setContentid(resultContentId);		
		placeDTO.setCreatedtime(CalendarUtil.transforCalendar(resultCTime));
		placeDTO.setModifiedtime(CalendarUtil.transforCalendar(resultMTime));
		placeDTO.setLocation(korAreaName);
		placeDTO.setTheme(korTheme);
		placeDTO.setMapx(Double.parseDouble(resultXLocation));
		placeDTO.setMapy(Double.parseDouble(resultYLocation)); 
		placeDao.insertWithDTO(placeDTO);
		
		if(resultFirstImage.equals("noTag")) {
			tourImageDTO.setImageurl("noImage");
			tourImageDTO.setContentid(resultContentId);
			tourImageDao.insertSingleTourImageRecord(tourImageDTO);
		}else {
			tourImageDTO.setImageurl(resultFirstImage);
			tourImageDTO.setContentid(resultContentId);
			tourImageDao.insertSingleTourImageRecord(tourImageDTO);
		}
		
		System.out.println("생성날짜:"+CalendarUtil.transforCalendar(resultCTime));
		System.out.println("수정날짜:"+CalendarUtil.transforCalendar(resultMTime));
		System.out.println("테마:"+korTheme);
		System.out.println("관광지고유번호:"+resultContentId);
		System.out.println("지역:"+korAreaName);
		System.out.println("대표이미지 url:"+resultFirstImage);
		System.out.println("x좌표:"+resultXLocation);
		System.out.println("y좌표:"+resultYLocation);
		System.out.println("--------------------------------- 지역 정보 끝 ----------------------------------");
	}
	
	
}





















