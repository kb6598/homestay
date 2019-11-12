package com.homestay.korea.API;

import java.io.IOException;
import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.homestay.korea.DTO.PlaceDTO;

public class ApiExplorerLocationBased{

	ApiExplorer api = null;
	public ApiExplorerLocationBased(){}
	
	public ApiExplorerLocationBased(PlaceDTO placeDTO){
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("mapX", String.valueOf(placeDTO.getMapx()));
		hm.put("mapY", String.valueOf(placeDTO.getMapy()));
		hm.put("radius", "2000");
		try {
			api = new ApiExplorer("locationBasedList", hm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JsonArray getJArray(){
		return api.getJArray();
	}
}
