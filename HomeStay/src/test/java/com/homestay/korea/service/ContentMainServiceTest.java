package com.homestay.korea.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homestay.korea.DTO.JoinPlaceTourImageDTO;
import com.homestay.korea.DTO.TourImageDTO;
import com.homestay.korea.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class ContentMainServiceTest {
		
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IContentMainService contentMainService;
	
	//test 마무리
	@Test
	public void testReadService() {
		List<JoinPlaceTourImageDTO> items = contentMainService.getJoinPlaceTourImageDTOForIndex("문화시설", "경기");
		
		for(JoinPlaceTourImageDTO item : items) {
			logger.info(item.toString());
		}
		
		
	}
	
}











