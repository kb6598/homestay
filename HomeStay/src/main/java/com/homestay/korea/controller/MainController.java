package com.homestay.korea.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homestay.korea.HomeController;

@Controller
@RequestMapping("/mainpage")
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/topview", method = RequestMethod.GET)
	public String topview(Locale locale, Model model) {

		
		return "homestay/mainPage/topView";
	}
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Locale locale, Model model) {

		
		return "homestay/mainPage/menu";
	}
	@RequestMapping(value = "/mainview", method = RequestMethod.GET)
	public String mainview(Locale locale, Model model) {

		
		return "homestay/mainPage/mainView";
	}
	@RequestMapping(value = "/subview", method = RequestMethod.GET)
	public String subview(Locale locale, Model model) {

		
		return "homestay/mainPage/subView";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {

		
		return "homestay/mainPage/index";
	}
	
	
}
