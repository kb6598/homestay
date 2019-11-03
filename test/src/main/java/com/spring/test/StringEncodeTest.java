package com.spring.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringEncodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException {



		String locs[] ={"전체","서울","경기","인천","강원","충청","대구","부산","울산","광주","제주"};
		String curLoc;

		curLoc = "전체";
		String result = "";
		String decoded_result;
		
		for(String loc : locs){
			result = "<a href='/main?location=";
			if(loc.equals(curLoc)){
				System.out.println("<div class='col-sm regionItem selected'>");
			}else{
				System.out.println("<div class='col-sm regionItem'>");
			}
			

			

			result += URLEncoder.encode(loc, "UTF-8");
			result +="><a>"+loc;
			result +="</a></div>";
			System.out.println(result);
		}
		
		



	}




}
