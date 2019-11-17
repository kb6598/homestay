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
import com.homestay.korea.service.IPlaceDeleteService;
import com.homestay.korea.service.IPlaceDetailDataDeleteService;
import com.homestay.korea.service.IPlaceDetailDataInsertService;
import com.homestay.korea.service.IPlaceDetailDataReadService;
import com.homestay.korea.service.IPlaceInsertService;
import com.homestay.korea.service.IPlaceReadService;
import com.homestay.korea.service.ITourImageDeleteService;
import com.homestay.korea.service.ITourImageReadService;
import com.homestay.korea.service.TourDataSchedulingService;


/*
 * 매일 관광지 데이터를 갱신하는 스케쥴러입니다.
 */
@Component
public class DataScheduler {
	
	@Autowired
	private IPlaceReadService placeReadService;
	
	@Autowired
	private IPlaceDeleteService placeDeleteService;
	
	@Autowired
	private IPlaceInsertService placeInsertService;
	
	@Autowired
	private IPlaceDetailDataReadService placeDetailDataReadService;
	
	@Autowired
	private IPlaceDetailDataDeleteService placeDetailDataDeleteService;
	
	@Autowired
	private IPlaceDetailDataInsertService placeDetailDataInsertService;
	
	@Autowired
	private ITourImageReadService tourImageReadService;
	
	@Autowired
	private ITourImageDeleteService tourImageDeleteService;
	
	@Autowired
	private TourDataSchedulingService tourDataSchedulingService;
	
	private AreaBasedData areaBasedData; //지역기반 정보 호출
	private CommonDetailData commonDetailData; //공통정보 호출
	private DetailData detailData; //세부정보 호출
	private TourImageData tourImageData; //상세이미지 호출
	
	
	public DataScheduler() {
		this.areaBasedData = new AreaBasedData();
		this.commonDetailData = new CommonDetailData();
		this.detailData = new DetailData();
		this.tourImageData = new TourImageData();
	}
	
	/*
	------------------------ 하루에 한번 갱신 --------------------------
	0.temp_contentid에 모든 관광지의 리스트를 가져와서 저장(지역기반)
	
	1.추가된 관광지 선별 방법(DB에 createdtime(등록일칼럼)저장돼있어야함)
   		:1-1.하루에 한번 tour api에 등록순(지역기반 관광정보 조회) 관광지 호출 
     	 1-2.첫페이지부터 차례대로 createdtime이 지난 하루내에 존재한다면 db에 저장(삽입), 하루가 넘어가면 종료

	2.수정된 관광지 선별 방법(DB에 modifiedtime(수정일) 저장돼있어야함) 	
   		:2-1.하루에 한번 tour api에 최근수정순(지역기반 관광정보 조회) 관광지 호출
     	 2-2.첫 페이지부터 차례대로 modifiedtime이 지난 하루내에 db에 존재하는 수정일과 다르다면 수정이 됐다는 것이기 때문에 update

	3.삭제된 관광지 선별 방법
   		:3-1.place테이블(모든 관광지가 존재한다는 전제하)과
     	 3-2.모든 관광지 리스트를 불러와 temp_contentid테이블에(place테이블과 조인을할) 저장
     	 3-3. https://postitforhooney.tistory.com/entry/DBMARIADB-SQL-%EC%98%88%EC%A0%9C%EB%A5%BC-%ED%86%B5%ED%95%9C-JOIN%EC%9D%98-%EC%A2%85%EB%A5%98-%ED%8C%8C%EC%95%85
     	 3-4.각 정보를 place테이블에서 삭제
	 */
	
	@Scheduled(cron="0 0 3 * * *") //매일 새벽 3시에 작동
	public void checkFiles() throws Exception {
		//삽입루틴
//		insertNewTourData(); //테스트 필요
		//수정루틴
//		updateModifiedTourData(); //테스트 필요
		//삭제루틴
	}
	
	//삽입하는 작업
	/*
	 * TO DO LIST
	 * 1.지역기반 한페이지에 10개 호출
	 * 2.<item>태그내에 <createdtime>태그의 값이 오늘 날짜기준 전날이라면 db에 데이터저장(지역정보,공통정보,세부정보,이미지정보)후 다음 관광지<item>으로 
	 * 3.<createdtime>태그의 값이 오늘날짜기준 전전날이라면 마무리
	 */
	private void insertNewTourData() {
		
		XmlString xmlStr = null;
		
		Map<String,String> createdTimeUriMap = new HashMap<String,String>();
//		basedAreaUriMap.put("pageNo",String.valueOf(pageNo)); //반복처리할것
		createdTimeUriMap.put("pageNo","1");
		createdTimeUriMap.put("numOfRows","50"); 
		createdTimeUriMap.put("listYN","Y");
		createdTimeUriMap.put("arrange","D"); //A는 제목순, D는 생성순, C는 수정순
		
		try {
			Api createdTimeOrder = new Api("areaBasedList", createdTimeUriMap, ServiceKey.TOTAL_SERVICEKEY[0]); //지역기반 호출(생성순)
			xmlStr = new XmlString(createdTimeOrder.getResultXmlStr());
			List<String> itemList = xmlStr.extractSpecificXmlStr("item");
			for(int i=0; i<itemList.size(); i++) {
				String itemXmlStr = itemList.get(i);
				String createdDay = CalendarUtil.extractDay(XmlString.extractXmlValue("<createdtime>", itemXmlStr));
				if(!createdDay.equals(getYesterday())) { //어제 새로운 관광지가 아니라면
					return;
				}
				String contentId = XmlString.extractXmlValue("<contentid>", itemXmlStr);
				String contentTypeId = XmlString.extractXmlValue("<contenttypeid>", itemXmlStr);
				
				//db에 종합적인 데이터 저장(지역기반,공통정보,세부정보,관광지 이미지)
				areaBasedData.storeSettedData(itemXmlStr);
				commonDetailData.storeSettedData(itemXmlStr, contentId);
				detailData.storeSettedData(itemXmlStr, contentId, contentTypeId);
				tourImageData.storeTourImageData(itemXmlStr, contentId);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	//어제 날짜의 day값을 반환한다.
	private String getYesterday() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE)-1;
		String strDay = String.valueOf(day);
		if(strDay.length()==1)
			return "0"+strDay;
		return strDay;
	}
	
	//수정된 관광지 수정하는 작업
	/*
	 * TO DO LIST
	 * 1.지역 기반 관광지 호출(50개씩 호출, 최근 수정순으로)
	 * 2.첫 페이지부터 차례대로 modifiedtime이 지난 하루내에 db에 존재하는 수정일과 다르다면 수정이 됐다는 것이기 때문에 update
	 */
	private void updateModifiedTourData() {
		
		XmlString xmlStr = null;
		
		Map<String,String> modifiedTimeUriMap = new HashMap<String,String>();
//		basedAreaUriMap.put("pageNo",String.valueOf(pageNo)); //반복처리할것
		modifiedTimeUriMap.put("pageNo","1");
		modifiedTimeUriMap.put("numOfRows","50"); 
		modifiedTimeUriMap.put("listYN","Y");
		modifiedTimeUriMap.put("arrange","C"); //A는 제목순, D는 생성순, C는 수정순
		
		try {
			//지역기반 호출(수정순)
			Api modifiedTimeOrder = new Api("areaBasedList", modifiedTimeUriMap, ServiceKey.TOTAL_SERVICEKEY[0]); 
			xmlStr = new XmlString(modifiedTimeOrder.getResultXmlStr());
			List<String> itemList = xmlStr.extractSpecificXmlStr("item");
			for(int i=0; i<itemList.size(); i++) {
				String itemXmlStr = itemList.get(i);
				String modifiedDay = CalendarUtil.extractDay(XmlString.extractXmlValue("<modifiedtime>", itemXmlStr));
				if(!modifiedDay.equals(getYesterday())) { //어제 수정된 관광지가 아니라면
					break;
				}
				String contentId = XmlString.extractXmlValue("<contentid>", itemXmlStr);
				String contentTypeId = XmlString.extractXmlValue("<contenttypeid>", itemXmlStr);
				
				//db에 존재하는 관광지의 modifiedtime(select해야함)과 modifiedDay가 다르다면 
				//place, place_detailData, tour_image테이블 delete후 insert
				if(!compareModifiedTime(contentId, modifiedDay)) {
					//종합적인 delete처리(place,place_detailData,tour_image)
					tourDataSchedulingService.deleteTourDataForScheduling(contentId);
					//종합적인 insert처리
					areaBasedData.storeSettedData(itemXmlStr);
					commonDetailData.storeSettedData(itemXmlStr, contentId);
					detailData.storeSettedData(itemXmlStr, contentId, contentTypeId);
					tourImageData.storeTourImageData(itemXmlStr, contentId);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//modifiedday를 비교해 boolean반환(수정날짜에서 day가 같다면 true 반환)
	public boolean compareModifiedTime(String contentId, String modifiedDay) {
		PlaceDTO placeDTO = placeReadService.getPlace(contentId);
		String compareToModifiedDay = CalendarUtil.extractDay(placeDTO.getModifiedtime());
		return compareToModifiedDay.equals(modifiedDay);
	}
	
	//삭제된 관광지 DB에서 삭제하는 작업
	/*
	 * TO DO LIST
	 * 1.지역기반으로 모든 관광지를 temp_contentid테이블에 저장
	 * 2.place테이블과 temp_contentid테이블을 outer join하여 temp_contentid에는 존재하지 않는데 place테이블에는 존재하는 관광지를 조회
	 * 3.place,place_detailData,tour_image테이블에서 해당 관광지들을 삭제
	 */
	private void deleteDeletedTourData() {
		
		
	}
	
	
}


























