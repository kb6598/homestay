package com.homestay.korea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.homestay.korea.API.ApiExplorerLocationBased;
import com.homestay.korea.DTO.PlaceDTO;
import com.homestay.korea.service.IPlaceDetailDataReadService;
import com.homestay.korea.service.IPlaceReadService;

@Controller
public class LocationBasedSightsController {
	
	@Autowired
	private IPlaceReadService placeReadService;
	
	@ResponseBody
	@RequestMapping(value="/location", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String location(@RequestParam("contentid") String contentid) {
		PlaceDTO placeDTO = placeReadService.getPlace(contentid);
		ApiExplorerLocationBased api = new ApiExplorerLocationBased(placeDTO);
		return api.getJArray().toString();
	}
}
