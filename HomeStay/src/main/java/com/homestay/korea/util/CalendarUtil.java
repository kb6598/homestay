package com.homestay.korea.util;

/*
 * 관광지호출로 전달받은 날짜와 관련된 클래스입니다.
 */
public class CalendarUtil {
	
	// 전달받은 날짜를 xxxx/xx/xx xx:xx:xx 형식으로 변환
	public static String transforCalendar(String date) {
		String year = date.substring(0, 4);
		String month = date.substring(4, 6);
		String day = date.substring(6, 8);
		String hour = date.substring(8, 10);
		String minute = date.substring(10, 12);
		String sec = date.substring(12, 14);

		return year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + sec;
	}
	
	//api호출로 전달받은 문자열 타입의 날짜에서 year/month/day의 문자열을 추출해내는 메서드
	public static String extractDay(String date) {
		if(date != null && !date.isEmpty()) {
			String year = date.substring(0, 4);
			String month = date.substring(4, 6);
			String day = date.substring(6, 8);
			return year + "/" + month + "/" + day;
		}
		return null;
	}
	
	//xxxx/xx/xx xx:xx:xx 형식의 문자열에서 year/monty/day를 추출해내는 메서드
	public static String extractTransformedDay(String date) {
		if(date != null && !date.isEmpty()) {
			return date.substring(0, 10);
		}
		return null;
	}
}



















