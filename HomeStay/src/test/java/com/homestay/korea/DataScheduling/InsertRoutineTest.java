package com.homestay.korea.DataScheduling;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homestay.korea.DAO.IPlaceDAO;
import com.homestay.korea.DAO.IPlaceDetailDataDAO;
import com.homestay.korea.DAO.ITourImageDAO;
import com.homestay.korea.common.ServiceKey;
import com.homestay.korea.config.RootConfig;
import com.homestay.korea.service.IPlaceReadService;
import com.homestay.korea.service.TempContentidService;
import com.homestay.korea.service.TourDataSchedulingService;
import com.homestay.korea.util.Api;
import com.homestay.korea.util.AreaBasedData;
import com.homestay.korea.util.CalendarUtil;
import com.homestay.korea.util.CommonDetailData;
import com.homestay.korea.util.DetailData;
import com.homestay.korea.util.TourImageData;
import com.homestay.korea.util.XmlString;

//데이터 스케쥴링 중 새로운 관광지 삽입하는 테스트클래스입니다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class InsertRoutineTest {
	
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
	
	public InsertRoutineTest() {
	}
	
	@Test
	public void insertNewTourData() {
		int pageNo=1;
		XmlString xmlStr = null;
		Map<String, String> createdTimeUriMap = new HashMap<String, String>();
		while(true) {	
			System.out.println("-----------------------pageNo:"+pageNo+"-----------------------");
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
					if (!createdDay.equals(getYesterday(3))) { 
						System.out.println("-----------------------어제 날짜가 아니라 삽입 return합니다. createdDay:"+createdDay+"-----------------------");
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
	
	// 어제 날짜의 day값을 반환한다.
	private String getYesterday(int minusDay) {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE) - minusDay;
		String strDay = String.valueOf(day);
		if (strDay.length() == 1)
			return "0" + strDay;
		return strDay;
	}
	
}

























