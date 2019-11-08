package com.homestay.korea.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.homestay.korea.DAO.IPlaceDAO;
import com.homestay.korea.DAO.IPlaceDetailDataDAO;
import com.homestay.korea.DAO.ITourImageDAO;
import com.homestay.korea.DTO.PlaceDTO;
import com.homestay.korea.DTO.PlaceDetailDataDTO;
import com.homestay.korea.DTO.TourImageDTO;
import com.homestay.korea.common.TagInfo;
import com.homestay.korea.config.RootConfig;
import com.homestay.korea.exception.LimitedRequestException;
import com.homestay.korea.exception.NotOkResponseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class TourAPITests {
	
	/*
선상원 : 
KaI%2FcewqprPhkm8XnSeaZV5lfBAZAiQSe0RCCjYJG7UDgj5a5ChYmXLG5GObAWG%2BxoBQC0HESNXkd88FtcAR1A%3D%3D

노원호 :
ZMvobRaDObK%2BFAohyI8niOVo9MI1W%2BVK7MRTb3ygvPsEyvrqfANugmGpLeRAeaVutOXbf0GDhS6cjojJt7QLzA%3D%3D

이민혁 : 
Yraqccx4LfA%2Bu6%2BRBKLwVEDFhi5woOoWBUZECv%2F0l%2Fs%2BL4s54Z0JX4TZDy7RJv%2FRdA%2FlFDp4eMqaTvmqzaO4XA%3D%3D

여수향 : 
qenZlJjZb6XaqFBDSk%2B6BE6hSgp4HMzlVHjuZV%2FN07OXNyH4dHxyXjyH3qtq8LyC6EC%2Bd1gOg0Tm2gR%2FusFSWQ%3D%3D

나평근 : 
nz39ogDb3ERsaiPwd4lfxl0pwSqRGkR6HtXkM%2Bcoe04m1iXMHmNFQgmz3mpRt0g2ns3wrzGiSueBRhdBE4PLkA%3D%3D

최우중 : 
ZgU24ffu7eXD%2BvDP%2Fgg1C7NmQWf4bpC6G879XYYYZjRDO59Ld5NY%2FTXdPTGVt2P3b%2BRHbr0eYyPw%2Bc%2FQpmqo7Q%3D%3D

이빌립 : 
XTqju5%2BKJ1B65Rcv%2FDQzBbher7JEH6YCJYshlzqThmSU97RsoM2tSIn2WotU8jsAOc3LWr9APLD98YplWCOWHw%3D%3D

김승현 :
5GNVseCsSklXvjRoIA81IY%2Bvu94C4OoBIeWM%2FQNuOUOKytgK6GWGx1IkOSY9gJHvZQ7yWBNy5fWFTiACpGYtVw%3D%3D
	 * 
	 */
	
	private final String SERVICEKEY = "KaI%2FcewqprPhkm8XnSeaZV5lfBAZAiQSe0RCCjYJG7UDgj5a5ChYmXLG5GObAWG%2BxoBQC0HESNXkd88FtcAR1A%3D%3D";
	private final int CALL_API_PAGE_COUNT = 100;
	
	@Autowired
	private IPlaceDAO placeDao;
	
	@Autowired
	private IPlaceDetailDataDAO placeDetailDao;
	
	@Autowired
	private ITourImageDAO tourImageDao;
	
	
	private Api basedArea; //지역기반 호출
	private Api commonData; //공통정보
//	private Api introData; //소개정보(특정 메서드로 호출함)
//	private Api imageData; //이미지정보(특정 메서드로 호출함)
	
	public TagInfo tagInfo;
	
	private PlaceDetailDataDTO placeDetailDataDTO; 
	private PlaceDTO placeDTO; 
	private TourImageDTO tourImageDTO; 
	
	public TourAPITests() {
		this.placeDTO = new PlaceDTO();
		this.placeDetailDataDTO = new PlaceDetailDataDTO();
		this.tourImageDTO = new TourImageDTO();
	}
	
//	@Test
//	public void handleException() {
//		//<resultCode>태그값이 22이면  서비스 요청제한횟수 초과에러(처리해줘야함)
//		//<resultCode>값이 0이외에는 모두 에러
//		
//		//관광지한페이지에 50개 * 100번호출하면 총 관광지 갯수 = 5000개
//		for(int i=1; i<CALL_API_PAGE_COUNT; i++) {
//			try {
//				callTourAPIToStoreDB(i);
//			}catch(LimitedRequestException e) {
//				//서비스 호출 제한 걸렸을때 처리
//			}catch(NotOkResponseException e) {
//				//응답이 바르지 못했을 때 처리
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	/*
	 * To do list
	 * 1. 지역기반으로 페이지단위(50개씩) 호출(o)
	 * 2. 가져온 50개에서 1개씩<item>정보들(addr(주소),areacode(지역코드),contentid(관광지고유번호),contenttypeid(테마),
	 *    createdtime(생성날짜), firstimage(원본이미지),firstImage2(썸네일이미지), modifiedtime(수정날짜), title(제목))을 파싱하고 데이터 준비(o)
	 * 3. 각 1개의 관광지의 공통정보 호출 (o)
	 * 4. 공통정보의 정보(overview(개요),homepage(홈페이지 주소),tel(전화번호),telname(전화번호 명) place_DetailData 테이블에 삽입
	 * 5. 각 1개의 관광지의 소개정보 호출 
	 * 6. 소개정보의 모든 태그와 value값을 place_detailData테이블에 파싱해서 삽입
	 * 	6-1. 각 관광지의 결과 태그값들을 추출(o)
	 * 	6-2. 추출한 태그값들을 파싱(o)
	 * 	6-3. 파싱한 값과 해당하는 value값 db(place_detailData)에 저장
	 * 7. 각 1개의 관광지의 이미지정보 호출
	 * 8. 이미지 url을 tour_image테이블의 imageUrl에 저장
	 */
	
	@Test
	public void callTourAPIToStoreDB() throws Exception {
		
		Map<String,String> basedAreaUriMap = new HashMap<String,String>();
//		basedAreaUriMap.put("pageNo",String.valueOf(pageNo)); //반복처리할것
		basedAreaUriMap.put("pageNo","7"); 
		basedAreaUriMap.put("numOfRows","200"); 
		basedAreaUriMap.put("listYN","Y");
		
		Map<String,String> commonDataUriMap = new HashMap<String,String>();
		commonDataUriMap.put("overviewYN", "Y");
		commonDataUriMap.put("defaultYN", "Y");
		commonDataUriMap.put("addrinfoYN", "Y");
		
		Map<String,String>  introDataUriMap= new HashMap<String,String>();
		
		Map<String,String> detailImageUriMap = new HashMap<String,String>();
		detailImageUriMap.put("ImageYN","Y");
		
		
		tagInfo = new TagInfo();
		
		String[] commonTempStrArr = {"<overview>","<addr1>","<tel>","<telname>","<title>"};

		//각각 api를 호출하고 결과에서 <resultCode>값을 확인해서 0000 이외면 exception 날림
		try {
			basedArea = new Api("areaBasedList", basedAreaUriMap, SERVICEKEY); //지역기반 호출
			int repeatCnt=0;
			int startIdx=0;
			int lastIdx=0;
			int criteriaIdx=0;
			String targetStr;
			String resultXmlStr = basedArea.getResultXmlStr();
			String resultCode=extractXmlValue(resultXmlStr,"<resultCode>");
			if(!resultCode.equals("0000")) { //중복코드
				if(resultCode.equals("0022"))
						throw new LimitedRequestException();
				throw new NotOkResponseException();
			}
			if(resultXmlStr.contains("<numOfRows>")) { //반복할 횟수 구하기
				repeatCnt = extractNumOfRows(resultXmlStr);
			}
			for(int i=0; i<repeatCnt; i++) {
				targetStr = resultXmlStr.substring(criteriaIdx);
				if(targetStr.contains("<item>")) { //이 태그 있냐 없냐 부터 해야함 
					startIdx = targetStr.indexOf("<item>"); 
					lastIdx = targetStr.indexOf("</item>");
					criteriaIdx += lastIdx+"</item>".length();
					String tempStr = targetStr.substring(startIdx, lastIdx);
					//<areacode>,<contentid>,<createdtime>,<modifiedtime>,<contenttypeid>
					String resultAreaCode = extractXmlValue(tempStr, "<areacode>"); 
					String korAreaName = tagInfo.areaCodeTag.get(resultAreaCode); //db에 넣어야함
					String resultContentId = extractXmlValue(tempStr, "<contentid>"); //파싱 필요없음
					String resultCTime = extractXmlValue(tempStr, "<createdtime>"); //파싱처리해야함
					String resultMTime = extractXmlValue(tempStr, "<modifiedtime>"); //파싱처리해야함
					String resultTypeId = extractXmlValue(tempStr, "<contenttypeid>"); //파싱처리해야함
					String korTheme = tagInfo.themeTag.get(resultTypeId); //db에 넣어야함
					String resultFirstImage = extractXmlValue(tempStr, "<firstimage>"); //원본이미지(없을 수도 있음)
					String resultThumnailImage = extractXmlValue(tempStr, "<firstimage2>"); //썸네일이미지(없을 수도 있음)
					
					String resultXLocation = extractXmlValue(tempStr,"<mapx>");
					String resultYLocation = extractXmlValue(tempStr,"<mapy>");
					
					System.out.println("--------------------------------- 지역 정보 시작---------------------------------");
					placeDTO.setContentid(resultContentId);
					placeDTO.setCreatedtime(transforCalendar(resultCTime));
					placeDTO.setModifiedtime(transforCalendar(resultMTime));
					placeDTO.setLocation(korAreaName);
					placeDTO.setTheme(korTheme);
					placeDTO.setMapx(Double.parseDouble(resultXLocation));
					placeDTO.setMapy(Double.parseDouble(resultYLocation));
					placeDao.insertWithDTO(placeDTO); //지역정보DB에 저장
					
					if(resultFirstImage.equals("noTag")) {
						tourImageDTO.setImageurl("noImage");
						tourImageDTO.setContentid(resultContentId);
						tourImageDao.insertSingleTourImageRecord(tourImageDTO);
					}
					
					System.out.println("생성날짜:"+transforCalendar(resultCTime));
					System.out.println("수정날짜:"+transforCalendar(resultMTime));
					System.out.println("테마:"+korTheme);
					System.out.println("관광지고유번호:"+resultContentId);
					System.out.println("지역:"+korAreaName);
//					System.out.println("원본이미지 url:"+resultFirstImage);
//					System.out.println("썸네일이미지 url:"+resultThumnailImage);
					System.out.println("--------------------------------- 지역 정보 끝---------------------------------");
					
					//--------------------------------------------------------------------------------------
					//공통정보 조회 호출(overview, homepage, tel, telname, title, addr1)
					if(commonDataUriMap.get("contentId") != null) {
						commonDataUriMap.replace("contentId", resultContentId);
					}else {
						commonDataUriMap.put("contentId", resultContentId);
					}
					commonData = new Api("detailCommon", commonDataUriMap, SERVICEKEY);
					String resultCommonDataXmlStr = commonData.getResultXmlStr();
					String resultCodeStr = extractXmlValue(resultCommonDataXmlStr, "<resultCode>");
					if(!resultCodeStr.equals("0000")) {
						if(resultCodeStr.equals("0022"))
								throw new LimitedRequestException();
						throw new NotOkResponseException();
					}
					if(resultCommonDataXmlStr.contains("<item>")) {
						String overviewData = extractXmlValue(resultCommonDataXmlStr, "<overview>");
						String addrData = extractXmlValue(resultCommonDataXmlStr, "<addr1>");
						String telData = extractXmlValue(resultCommonDataXmlStr, "<tel>");
						String telnameData = extractXmlValue(resultCommonDataXmlStr, "<telname>");
						String title = extractXmlValue(resultCommonDataXmlStr, "<title>");
						System.out.println("--------------------------------- 공통 정보 시작---------------------------------");
						
						for(int idx=0; idx<commonTempStrArr.length; idx++) {
							if(!extractXmlValue(resultCommonDataXmlStr,commonTempStrArr[idx]).equals("noTag")) {
								placeDetailDataDTO.setContent_category(tagInfo.commonTag.get(commonTempStrArr[idx]));
								placeDetailDataDTO.setContent(extractXmlValue(resultCommonDataXmlStr,commonTempStrArr[idx]));
								placeDetailDataDTO.setContentid(resultContentId);
								placeDetailDao.insert(placeDetailDataDTO); //공통db에 저장
							}
						}
						
						System.out.println("개요:" + overviewData);
						System.out.println("주소:" + addrData);
						System.out.println("전화번호:" + telData);
						System.out.println("전화번호 명:"+telnameData);
						System.out.println("제목:"+title);
						System.out.println("--------------------------------- 공통 정보 끝---------------------------------");
					}
					
					//--------------------------------------------------------------------------------------
					//세부정보 조회 호출() 
					introDataUriMap.put("contentTypeId", resultTypeId); //갱신해야함
					introDataUriMap.put("contentId", resultContentId); //갱신해야함
					Map<String,String> eachNodeNames=extractXmlNodeAndValue(makeAPIUri("detailIntro", introDataUriMap, SERVICEKEY));
					Map<String,String> resultDetailMap = new HashMap<>(); //DB에 저장해야하는 파싱된정보
					System.out.println("--------------------------------- 상세 정보 시작---------------------------------");
					for(Map.Entry<String,String> entry : eachNodeNames.entrySet()){
						String key = tagInfo.detailIntroTag.get(entry.getKey());
						if(key == null) {
							continue;
						}
						resultDetailMap.put(key, entry.getValue());
						placeDetailDataDTO.setContent_category(key);
						placeDetailDataDTO.setContent(entry.getValue()); //문제점이 value값에 <br/>태그라던가 &nbsp;등 html요소가 포함되어있음
						placeDetailDataDTO.setContentid(resultContentId);
						placeDetailDao.insert(placeDetailDataDTO); //상세정보db에 저장
						System.out.println("상세정보 키값:" + key + ", 상세정보 value값:" + entry.getValue());
					}
					System.out.println("--------------------------------- 상세 정보 끝---------------------------------");
					
					//--------------------------------------------------------------------------------------
					//이미지정보 조회 호출()
					detailImageUriMap.put("contentId", resultContentId);
					Map<String,String> eachImageUrl=extractXmlNodeAndValue(makeAPIUri("detailImage", detailImageUriMap, SERVICEKEY));
					System.out.println("--------------------------------- 이미지 정보 시작---------------------------------");
					if(!eachImageUrl.isEmpty()) {
						for(Map.Entry<String,String> entry : eachImageUrl.entrySet()) {
							String nodeName = entry.getKey();
							String value = entry.getValue();
							if(nodeName.equals("originimgurl")) { //이미지정보가 존재한다면
								tourImageDTO.setContentid(resultContentId);
								tourImageDTO.setImageurl(value);
								tourImageDao.insertSingleTourImageRecord(tourImageDTO); //이미지 정보 db에저장
								System.out.println("키값:" + nodeName + ", value값: " + value);
							}
						}
					}
					System.out.println("--------------------------------- 이미지 정보 끝---------------------------------");
					System.out.println();
					System.out.println();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//<numOfRows>태그를 참조해서 api호출결과값의 갯수를 추출
	private int extractNumOfRows(String xmlStr) {
		int startIdx=xmlStr.indexOf("<numOfRows>");
		int lastIdx=xmlStr.indexOf("</numOfRows>");
		startIdx+="<numOfRows>".length();
		String resultRows = xmlStr.substring(startIdx,lastIdx);
//		System.out.println("numOfRows: " + xmlStr.substring(startIdx,lastIdx));
		return Integer.parseInt(resultRows);
	}
	
	//전달한 xml문자열에서 전달한 태그(태그포함)에 해당하는 값을 반환한다.
	private String extractXmlValue(String xmlStr, String tag) {
		if(xmlStr.contains(tag)) {
			String lastTagName = tag.replace("<","</");
			int startIdx=xmlStr.indexOf(tag);
			int lastIdx=xmlStr.indexOf(lastTagName);
			startIdx+=tag.length();
			String resultValue = xmlStr.substring(startIdx,lastIdx);
			return resultValue;
		}
		return "noTag";
	}
	
	//전달받은 날짜를 xxxx/xx/xx xx:xx:xx 형식으로 변환
	private String transforCalendar(String date) {
		String year = date.substring(0,4);
		String month = date.substring(4,6);
		String day = date.substring(6,8);
		String hour = date.substring(8,10);
		String minute = date.substring(10,12);
		String sec = date.substring(12,14);
		
		return year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + sec;
	}
	
	
	private Map<String,String> extractXmlNodeAndValue(String callApiStr) throws LimitedRequestException,NotOkResponseException{
		
		Map<String,String> extractedXmlNodeAndValue = new HashMap<>();
		BufferedReader br = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            String urlstr = callApiStr;
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
            String result = "";
            String line;
            while ((line = br.readLine()) != null) {
                result = result + line.trim();
            }
            
            //exception날릴지 확인하는 부분
            String resultCode=extractXmlValue(result,"<resultCode>");
			if(!resultCode.equals("0000")) { //중복코드
				if(resultCode.equals("0022"))
						throw new LimitedRequestException();
				throw new NotOkResponseException();
			}
            
            InputSource is = new InputSource(new StringReader(result));
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr = xpath.compile("//items/item");
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                NodeList child = nodeList.item(i).getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    if(!node.getTextContent().isEmpty() && !node.getTextContent().equals(""))
                    	extractedXmlNodeAndValue.put(node.getNodeName(),node.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return extractedXmlNodeAndValue;
	}
	
	
	private String makeAPIUri(String urlAddr, Map<String, String> urlMap, String serviceKey) {
		StringBuilder urlBuilder = null;
		try {
			urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"+urlAddr); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode(serviceKey, "UTF-8")); /*공공데이터포털에서*/
			urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
			urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			for(Map.Entry<String,String> entry : urlMap.entrySet()){
				urlBuilder.append("&" + URLEncoder.encode(entry.getKey(),"UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
        return urlBuilder.toString();
	}
	
}


class Api{
	public String resultXmlStr ="";
	
	public String getResultXmlStr() {
		return this.resultXmlStr;
	}
	
	//수향이가 작업한 ApiExplorer 조금 변경
	public Api(String urlAddr, Map<String, String> urlMap, String serviceKey) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"+urlAddr); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode(serviceKey, "UTF-8")); /*공공데이터포털에서*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        for(Map.Entry<String,String> entry : urlMap.entrySet()){
        	System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        	urlBuilder.append("&" + URLEncoder.encode(entry.getKey(),"UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        //urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*json방식으로 변경*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        resultXmlStr=sb.toString();
	}
}


















