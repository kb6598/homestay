package com.homestay.korea.util;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.homestay.korea.DTO.PlaceDTO;
import com.homestay.korea.common.ServiceKey;
import com.homestay.korea.exception.NoContentidExistsException;
import com.homestay.korea.service.IPlaceReadService;
import com.homestay.korea.service.TempContentidService;
import com.homestay.korea.service.TourDataSchedulingService;

/*
 * 매일 관광지 데이터를 갱신하는 스케쥴러입니다.
 */
@Component
public class DataScheduler {

	@Autowired
	private IPlaceReadService placeReadService;

	@Autowired
	private TourDataSchedulingService tourDataSchedulingService;

	@Autowired
	private TempContentidService tempContentidService;

	@Autowired
	private AreaBasedData areaBasedData; // 지역기반 정보 호출
	
	@Autowired
	private CommonDetailData commonDetailData; // 공통정보 호출
	
	@Autowired
	private DetailData detailData; // 세부정보 호출
	
	@Autowired
	private TourImageData tourImageData; // 상세이미지 호출

	public DataScheduler() {
		
	}

	/*
	 * ------------------------ 하루에 한번 갱신 --------------------------
	 * 						      매일 새벽 3시에 작동
	 */
	@Scheduled(cron = "0 0 3 * * *") 
	public void renewTourDataInDB() throws Exception {
		// 삽입루틴
		// insertNewTourData(); //테스트 완료
		// 수정루틴
		// updateModifiedTourData(); //테스트 필요
		// 삭제루틴
		//deleteDeletedTourData //테스트 필요
	}

	/*
	 * --삽입하는 작업--
	 * TO DO LIST 
	 * 1.지역기반 생성순으로 호출(50개씩) 
	 * 2.<item>태그내에 <createdtime>태그의 값이 오늘 날짜기준 전날이라면 db에 데이터저장(지역정보,공통정보,세부정보,이미지정보) 
	 * 3.<createdtime>태그의 값이 오늘날짜기준 전날이 아니라면 마무리(전전날이라면 의미)
	 */
	private void insertNewTourData() {
		int pageNo=1;
		XmlString xmlStr = null;
		Map<String, String> createdTimeUriMap = new HashMap<String, String>();
		while(true) {	
			createdTimeUriMap.put("pageNo", String.valueOf(pageNo));
			createdTimeUriMap.put("numOfRows", "50");
			createdTimeUriMap.put("listYN", "Y");
			createdTimeUriMap.put("arrange", "D"); //D는 생성순
			try {
				Api createdTimeOrder = new Api("areaBasedList", createdTimeUriMap, ServiceKey.TOTAL_SERVICEKEY[7]); //지역기반호출
				xmlStr = new XmlString(createdTimeOrder.getResultXmlStr());
				List<String> itemList = xmlStr.extractSpecificXmlStr("item");
				for (int i = 0; i < itemList.size(); i++) {
					String itemXmlStr = itemList.get(i);
					String contentId = XmlString.extractXmlValue("<contentid>", itemXmlStr);
					String contentTypeId = XmlString.extractXmlValue("<contenttypeid>", itemXmlStr);
					String createdDay = CalendarUtil.extractDay(XmlString.extractXmlValue("<createdtime>", itemXmlStr));
					if (!createdDay.equals(getBeforeday(1))) { //어제 새로운 관광지가 아니라면
						System.out.println("-----------------------지정한 날짜가 아니라 return합니다. createdDay:"+createdDay+"-----------------------");
						return;
					}
					// db에 종합적인 데이터 저장(지역기반,공통정보,세부정보,관광지 이미지)
					areaBasedData.storeSettedData(itemXmlStr);
					commonDetailData.storeSettedData(itemXmlStr, contentId);
					detailData.storeSettedData(itemXmlStr, contentId, contentTypeId);
					tourImageData.storeTourImageData(itemXmlStr, contentId);
				}
				pageNo++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 오늘 기준 날짜기준 beforeDay을 반환한다.(년/월/일 형식으로 반환)
	private String getBeforeday(int beforeDay) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE) - beforeDay;
		String strDay = String.valueOf(day);
		if (strDay.length() == 1)
			strDay = "0" + strDay;
		return year+"/"+month+"/"+strDay;
	}

	/*
	 * --수정된 관광지 DB수정하는 작업--
	 * TO DO LIST 
	 * 1.지역 기반 관광지 호출(50개씩 호출, 최근 수정순으로) 
	 * 2.첫 페이지부터 차례대로 modifiedtime이 지난 하루내에 수정이 됐다는 것이기 때문에 update
	 */
	private void updateModifiedTourData() {
		int pageNo=1;
		XmlString xmlStr = null;
		Map<String, String> modifiedTimeUriMap = new HashMap<String, String>();
		while(true) {
			modifiedTimeUriMap.put("pageNo", String.valueOf(pageNo));
			modifiedTimeUriMap.put("numOfRows", "50");
			modifiedTimeUriMap.put("listYN", "Y");
			modifiedTimeUriMap.put("arrange", "C"); //C는 수정순
			try {
				// 지역기반 호출(수정순)
				Api modifiedTimeOrder = new Api("areaBasedList", modifiedTimeUriMap, ServiceKey.TOTAL_SERVICEKEY[7]);
				xmlStr = new XmlString(modifiedTimeOrder.getResultXmlStr());
				List<String> itemList = xmlStr.extractSpecificXmlStr("item");
				for (int i = 0; i < itemList.size(); i++) {
					String itemXmlStr = itemList.get(i);
					String contentId = XmlString.extractXmlValue("<contentid>", itemXmlStr);
					String contentTypeId = XmlString.extractXmlValue("<contenttypeid>", itemXmlStr);
					String modifiedDay = CalendarUtil.extractDay(XmlString.extractXmlValue("<modifiedtime>", itemXmlStr));
					if (!modifiedDay.equals(getBeforeday(1))) { // 어제 수정된 관광지가 아니라면 return
						System.out.println("-----------------------지정한 날짜가 아니라 return합니다. modifiedDay:"+modifiedDay+"-----------------------");
						return;
					}
					// db에 존재하는 관광지의 modifiedtime(select해야함)과 modifiedDay가 다르다면
					// place, place_detailData, tour_image테이블 delete후 insert
					if (!compareModifiedTime(contentId, modifiedDay)) {
						// 종합적인 delete처리(place,place_detailData,tour_image)
						tourDataSchedulingService.deleteTourDataForScheduling(contentId);
						// 종합적인 insert처리
						areaBasedData.storeSettedData(itemXmlStr);
						commonDetailData.storeSettedData(itemXmlStr, contentId);
						detailData.storeSettedData(itemXmlStr, contentId, contentTypeId);
						tourImageData.storeTourImageData(itemXmlStr, contentId);
					}
				}
				pageNo++;
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	}
	
	
	// modifiedday를 비교해 boolean반환(수정날짜에서 day(=일자)가 같다면 true 반환)
	public boolean compareModifiedTime(String contentId, String modifiedDay) {
		PlaceDTO placeDTO = placeReadService.getPlace(contentId);
		String compareToModifiedDay = CalendarUtil.extractTransformedDay(placeDTO.getModifiedtime());
		return compareToModifiedDay.equals(modifiedDay);
	}

	/*
	 * --삭제된 관광지 DB에서 삭제하는 작업--
	 * TO DO LIST 
	 * 1.지역기반으로 모든 관광지를 temp_contentid테이블에 저장(contentid만 저장) 
	 * 2.place테이블과 temp_contentid테이블을 outer join하여 temp_contentid테이블에는 존재하지 않는데 place테이블에는 존재하는 관광지의 contentid를 조회 
	 * 3.place,place_detailData,tour_image테이블에서 조회된 관광지들을 삭제
	 */
	private void deleteDeletedTourData() {

		int pageNo=1;
		XmlString xmlStr = null;
		tempContentidService.truncateTempContntid(); //처음에 temp_contentid테이블의 관광지 데이터 삭제
		Map<String, String> areaBasedUriMap = new HashMap<String, String>();
		
		//1.temp_contentid테이블에 현재의tour api에서 제공하는 모든 관광지들을 저장하는 작업
		while(true) {
			areaBasedUriMap.put("pageNo",String.valueOf(pageNo));
			areaBasedUriMap.put("numOfRows", "999"); //(한번에 호출할 수 있는 갯수가 999개가 제한인것 같습니다)
			areaBasedUriMap.put("listYN", "Y");
			System.out.println("temp_contentid테이블에 관광지 데이터들을 삽입하기 위한 페이지 번호: "+pageNo);
			try {
				Api areaBasedApi = new Api("areaBasedList", areaBasedUriMap, ServiceKey.TOTAL_SERVICEKEY[7]);
				xmlStr = new XmlString(areaBasedApi.getResultXmlStr());
				List<String> itemList = xmlStr.extractSpecificXmlStr("item");
				for (int i = 0; i < itemList.size(); i++) {
					String itemXmlStr = itemList.get(i);
					String contentId = XmlString.extractXmlValue("<contentid>", itemXmlStr);
					// temp_contentid테이블에 contentid삽입
					tempContentidService.insertTempContntid(contentId);
					System.out.println("temp_contentid테이블에 삽입된 contentid:"+contentId);
				}
				pageNo++;
				if (itemList.size() != 999) { //마지막 페이지라는 의미이므로 while문 탈출
					System.out.println("temp_contentid테이블에 관광지 데이터들을 삽입하기 위한 (마지막)페이지 번호: " + --pageNo);
					System.out.println("temp_contentid테이블에 관광지 데이터들을 삽입하기 위한 마지막 페이지에서 관광지 순번 번호: " + itemList.size());
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//2.place테이블과 temp_contentid테이블을 outer join하여 temp_contentid테이블에는 존재하지 않는데 place테이블에는 존재하는 관광지의 contentid를 조회 
		List<String> deletedContentidList = tempContentidService.getDeletedContentid();
		
		//3.place,place_detailData,tour_image테이블에서 조회된 관광지들을 삭제
		for(String deleteTargetContentid : deletedContentidList) {
			if(!tourDataSchedulingService.deleteTourDataForScheduling(deleteTargetContentid)) {
				throw new NoContentidExistsException(deleteTargetContentid);
			}
		}
		
	}

}


























