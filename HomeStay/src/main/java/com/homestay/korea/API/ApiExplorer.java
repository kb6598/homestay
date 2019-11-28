package com.homestay.korea.API;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.homestay.korea.HomeController;

import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer{
	String r ="";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public ApiExplorer(String urlAddr, Map<String, String> urlMap) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"+urlAddr); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=nz39ogDb3ERsaiPwd4lfxl0pwSqRGkR6HtXkM%2Bcoe04m1iXMHmNFQgmz3mpRt0g2ns3wrzGiSueBRhdBE4PLkA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("nz39ogDb3ERsaiPwd4lfxl0pwSqRGkR6HtXkM%2Bcoe04m1iXMHmNFQgmz3mpRt0g2ns3wrzGiSueBRhdBE4PLkA%3D%3D", "UTF-8")); /*공공데이터포털에서*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        for(Map.Entry<String,String> entry : urlMap.entrySet()){
        	urlBuilder.append("&" + URLEncoder.encode(entry.getKey(),"UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
        	urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*콘텐츠 개요 조회여부*/
        }
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*json방식으로 변경*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        	
        	
        	//한글깨짐 해결
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        r=sb.toString();
	}
	
	public JsonArray getJArray(){
        JsonObject jsonObject = new JsonParser().parse(r).getAsJsonObject();
        JsonObject jsonObject2 = (JsonObject) jsonObject.get("response").getAsJsonObject().get("body").getAsJsonObject().get("items");
        JsonArray jsonArray = jsonObject2.getAsJsonArray("item");
        
		return jsonArray;
	}
}