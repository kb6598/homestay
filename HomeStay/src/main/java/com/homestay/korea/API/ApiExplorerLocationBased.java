package com.homestay.korea.API;

import java.io.IOException;
import java.util.HashMap;

public class ApiExplorerLocationBased{

	public ApiExplorerLocationBased(){
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("numOfRows", "5");
		hm.put("mapX", "126.981611");
		hm.put("mapY", "37.568477");
		hm.put("radius", "2000");
		try {
			ApiExplorer api = new ApiExplorer("locationBasedList", hm);
			api.getJArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
