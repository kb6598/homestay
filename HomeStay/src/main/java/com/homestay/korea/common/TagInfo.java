package com.homestay.korea.common;

import java.util.HashMap;
import java.util.Map;

public class TagInfo {
	
	public Map<String,String> themeTag;
	public Map<String,String> areaCodeTag;
	public Map<String,String> detailIntroTag;
	public Map<String,String> commonTag;
	
	public TagInfo() {
		this.themeTag = new HashMap<>();
		this.areaCodeTag = new HashMap<>();
		this.detailIntroTag = new HashMap<>();
		this.commonTag = new HashMap<>();
		
		//지역코드표에따른 각 지역 이름 매칭
		areaCodeTag.put("1", "서울");
		areaCodeTag.put("2", "인천");
		areaCodeTag.put("3", "대전");
		areaCodeTag.put("4", "대구");
		areaCodeTag.put("5", "광주");
		areaCodeTag.put("6", "부산");
		areaCodeTag.put("7", "울산");
		areaCodeTag.put("8", "세종특별자치시");
		areaCodeTag.put("31", "경기도");
		areaCodeTag.put("32", "강원도");
		areaCodeTag.put("33", "충청북도");
		areaCodeTag.put("34", "충청남도");
		areaCodeTag.put("35", "경상북도");
		areaCodeTag.put("36", "경상남도");
		areaCodeTag.put("37", "전라북도");
		areaCodeTag.put("38", "전라남도");
		areaCodeTag.put("39", "제주도");

		//-----------------------------------------------------------------------------
		//공통정보 태그값(프로젝트 설계상에 필요한 정보만 들어가 있음)
		commonTag.put("<overview>","개요");
		commonTag.put("<addr1>","주소");
		commonTag.put("<tel>","전화번호");
		commonTag.put("<telname>","전화번호 명");
		commonTag.put("<title>","제목");
		
		
		//-----------------------------------------------------------------------------
		//테마태그표에 따른 태그값(여행코스와 숙박은 설계에 포함되어 있지 않은 부분이였으나 데이터는 들어가있음)
		themeTag.put("12","관광지");
		themeTag.put("14","문화시설");
		themeTag.put("15","행사/공연/축제");
		themeTag.put("25","여행코스");
		themeTag.put("28","레포츠");
		themeTag.put("32","숙박");
		themeTag.put("38","쇼핑");
		themeTag.put("39","음식점");
		
		//-----------------------------------------------------------------------------
		//소개정보 태그의 한글 값
		detailIntroTag.put("accomcount","수용인원");
		detailIntroTag.put("chkbabycarriage","유모차대여 정보");
		detailIntroTag.put("chkcreditcard","신용카드가능 정보");
		detailIntroTag.put("chkpet","애완동물동반가능 정보");
		detailIntroTag.put("expagerange","체험가능 연령");
		detailIntroTag.put("expguide","체험안내");
		detailIntroTag.put("heritage1","세계 문화유산 유무");
		detailIntroTag.put("heritage2","세계 자연유산 유무");
		detailIntroTag.put("heritage3","세계 기록유산 유무");
		detailIntroTag.put("infocenter","문의 및 안내");
		detailIntroTag.put("opendate","개장일");
		detailIntroTag.put("parking","주차시설");
		detailIntroTag.put("restdate","쉬는날");
		detailIntroTag.put("useseason","이용시기");
		detailIntroTag.put("usetime","이용시간");
		detailIntroTag.put("accomcountculture","수용인원");
		detailIntroTag.put("chkbabycarriageculture","유모차대여 정보");
		detailIntroTag.put("chkcreditcardculture","신용카드가능 정보");
		detailIntroTag.put("chkpetculture","애완동물동반가능 정보");
		detailIntroTag.put("discountinfo","할인정보");
		detailIntroTag.put("infocenterculture","문의 및 안내");
		detailIntroTag.put("parkingculture","주차시설");
		detailIntroTag.put("parkingfee","주차요금");
		detailIntroTag.put("restdateculture","쉬는날");
		detailIntroTag.put("usefee","이용요금");
		detailIntroTag.put("usetimeculture","이용시간");
		detailIntroTag.put("scale","규모");
		detailIntroTag.put("spendtime","관람 소요시간");
		detailIntroTag.put("agelimit","관람 가능연령");
		detailIntroTag.put("bookingplace","예매처");
		detailIntroTag.put("discountinfofestival","할인정보");
		detailIntroTag.put("eventenddate","행사 종료일");
		detailIntroTag.put("eventhomepage","행사 홈페이지");
		detailIntroTag.put("eventplace","행사 장소");
		detailIntroTag.put("eventstartdate","행사 시작일");
		detailIntroTag.put("festivalgrade","축제등급");
		detailIntroTag.put("placeinfo","행사장 위치안내");
		detailIntroTag.put("playtime","공연시간");
		detailIntroTag.put("program","행사 프로그램");
		detailIntroTag.put("spendtimefestival","관람 소요시간");
		detailIntroTag.put("sponsor1","주최자 정보");
		detailIntroTag.put("sponsor1tel","주최자 연락처");
		detailIntroTag.put("sponsor2","주관사 정보");
		detailIntroTag.put("sponsor2tel","주관사 연락처");
		detailIntroTag.put("subevent","부대행사");
		detailIntroTag.put("usetimefestival","이용요금");
		detailIntroTag.put("distance","코스 총거리");
		detailIntroTag.put("infocentertourcourse","문의 및 안내");
		detailIntroTag.put("schedule","코스 일정");
		detailIntroTag.put("taketime","코스 총 소요시간");
		detailIntroTag.put("theme","코스 테마");
		detailIntroTag.put("accomcountleports","수용인원");
		detailIntroTag.put("chkbabycarriageleports","유모차대여 정보");
		detailIntroTag.put("chkcreditcardleports","신용카드가능 정보");
		detailIntroTag.put("chkpetleports","애완동물동반가능 정보");
		detailIntroTag.put("expagerangeleports","체험 가능연령");
		detailIntroTag.put("infocenterleports","문의 및 안내");
		detailIntroTag.put("openperiod","개장기간");
		detailIntroTag.put("parkingfeeleports","주차요금");
		detailIntroTag.put("parkingleports","주차시설");
		detailIntroTag.put("reservation","예약안내");
		detailIntroTag.put("restdateleports","쉬는날");
		detailIntroTag.put("scaleleports","규모");
		detailIntroTag.put("usefeeleports","입장료");
		detailIntroTag.put("usetimeleports","이용시간");
		detailIntroTag.put("accomcountlodging","수용 가능인원");
		detailIntroTag.put("benikia","베니키아 여부");
		detailIntroTag.put("checkintime","입실 시간");
		detailIntroTag.put("checkouttime","퇴실 시간");
		detailIntroTag.put("chkcooking","객실내 취사 여부");
		detailIntroTag.put("foodplace","식음료장");
		detailIntroTag.put("goodstay","굿스테이 여부");
		detailIntroTag.put("hanok","한옥 여부");
		detailIntroTag.put("infocenterlodging","문의 및 안내");
		detailIntroTag.put("parkinglodging","주차시설");
		detailIntroTag.put("pickup","픽업 서비스");
		detailIntroTag.put("roomcount","객실수");
		detailIntroTag.put("reservationlodging","예약안내");
		detailIntroTag.put("reservationurl","예약안내 홈페이지");
		detailIntroTag.put("roomtype","객실유형");
		detailIntroTag.put("scalelodging","규모");
		detailIntroTag.put("subfacility","부대시설 (기타)");
		detailIntroTag.put("barbecue","바비큐장 여부");
		detailIntroTag.put("beauty","뷰티시설 정보");
		detailIntroTag.put("beverage","식음료장 여부");
		detailIntroTag.put("bicycle","자전거 대여 여부");
		detailIntroTag.put("campfire","캠프파이어 여부");
		detailIntroTag.put("fitness","휘트니스 센터 여부");
		detailIntroTag.put("karaoke","노래방 여부");
		detailIntroTag.put("publicbath","공용 샤워실 여부");
		detailIntroTag.put("publicpc","공용 PC실 여부");
		detailIntroTag.put("sauna","사우나실 여부");
		detailIntroTag.put("seminar","세미나실 여부");
		detailIntroTag.put("sports","스포츠 시설 여부");
		detailIntroTag.put("refundregulation","환불규정");
		detailIntroTag.put("chkbabycarriageshopping","유모차대여 정보");
		detailIntroTag.put("chkcreditcardshopping","신용카드가능 정보");
		detailIntroTag.put("chkpetshopping","애완동물동반가능 정보");
		detailIntroTag.put("culturecenter","문화센터 바로가기");
		detailIntroTag.put("fairday","장서는 날");
		detailIntroTag.put("infocentershopping","문의 및 안내");
		detailIntroTag.put("opendateshopping","개장일");
		detailIntroTag.put("opentime","영업시간");
		detailIntroTag.put("parkingshopping","주차시설");
		detailIntroTag.put("restdateshopping","쉬는날");
		detailIntroTag.put("restroom","화장실 설명");
		detailIntroTag.put("saleitem","판매 품목");
		detailIntroTag.put("saleitemcost","판매 품목별 가격");
		detailIntroTag.put("scaleshopping","규모");
		detailIntroTag.put("shopguide","매장안내");
		detailIntroTag.put("chkcreditcardfood","신용카드가능 정보");
		detailIntroTag.put("discountinfofood","할인정보");
		detailIntroTag.put("firstmenu","대표 메뉴");
		detailIntroTag.put("infocenterfood","문의 및 안내");
		detailIntroTag.put("kidsfacility","어린이 놀이방 여부");
		detailIntroTag.put("opendatefood","개업일");
		detailIntroTag.put("opentimefood","영업시간");
		detailIntroTag.put("packing","포장 가능");
		detailIntroTag.put("parkingfood","주차시설");
		detailIntroTag.put("reservationfood","예약안내");
		detailIntroTag.put("restdatefood","쉬는날");
		detailIntroTag.put("scalefood","규모");
		detailIntroTag.put("seat","좌석수");
		detailIntroTag.put("smoking","금연/흡연 여부");
		detailIntroTag.put("treatmenu","취급 메뉴");
	}
	
}





























