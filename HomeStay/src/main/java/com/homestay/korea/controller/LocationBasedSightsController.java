package com.homestay.korea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.homestay.korea.API.ApiExplorerLocationBased;

@Controller
public class LocationBasedSightsController {
	
	@ResponseBody
	@RequestMapping(value="/location", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String location(@RequestParam("contentid") String contentid) {
		ApiExplorerLocationBased api = new ApiExplorerLocationBased();
		return api.getJArray().toString();
	}
}
