package com.homestay.korea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homestay.korea.API.ApiExplorerLocationBased;

@Controller
public class LocationBasedSightsController {
	@GetMapping("/location")
	public void location(@RequestParam("contentId") String contentId) {
		System.out.println(contentId);
		ApiExplorerLocationBased api = new ApiExplorerLocationBased();
		//return "/main";
	}
}
