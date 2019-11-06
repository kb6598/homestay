package com.homestay.korea.API;

import java.io.IOException;
import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiExplorerLocationBased{

	ApiExplorer api = null;
	
	public ApiExplorerLocationBased(){
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("numOfRows", "5");
		hm.put("mapX", "126.981611");
		hm.put("mapY", "37.568477");
		hm.put("radius", "2000");
		try {
			api = new ApiExplorer("locationBasedList", hm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JsonArray getJArray(){
		return api.getJArray();
	}
}
