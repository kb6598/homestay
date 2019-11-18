package com.homestay.korea.DataScheduling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homestay.korea.common.ServiceKey;
import com.homestay.korea.config.RootConfig;
import com.homestay.korea.exception.NoContentidExistsException;
import com.homestay.korea.service.TempContentidService;
import com.homestay.korea.service.TourDataSchedulingService;
import com.homestay.korea.util.Api;
import com.homestay.korea.util.XmlString;

//데이터 스케쥴링 중  관광지를 tourapi와 비교하여 db에서 삭제테스트 클래스입니다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class DeleteRoutineTest {

	@Autowired
	private TourDataSchedulingService tourDataSchedulingService;

	@Autowired
	private TempContentidService tempContentidService;
	
	@Test
	public void deleteDeletedTourData() {

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
			System.out.println("삭제할 관광지 번호:" + deleteTargetContentid);
			if(!tourDataSchedulingService.deleteTourDataForScheduling(deleteTargetContentid)) {
				throw new NoContentidExistsException(deleteTargetContentid);
			}
		}
		
	}
}





























