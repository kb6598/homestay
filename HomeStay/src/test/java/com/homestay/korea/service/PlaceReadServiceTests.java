package com.homestay.korea.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homestay.korea.DTO.PlaceDTO;
import com.homestay.korea.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class PlaceReadServiceTests {
		
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPlaceReadService palceService;
	
	//test 마무리
	@Test
	public void testReadService() {
		PlaceDTO palce = palceService.getPlace("1");
		logger.info(palce.toString());
	}
	
}











