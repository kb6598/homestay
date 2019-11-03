package com.homestay.korea.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homestay.korea.DAO.IPlaceDAO;
import com.homestay.korea.DAO.ITourImageDAO;
import com.homestay.korea.DTO.PlaceDTO;
import com.homestay.korea.DTO.TourImageDTO;
import com.homestay.korea.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class TourImageDAOTests2 {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ITourImageDAO tourImageDAO;
	
	//test 마무리
	@Test
	public void testReadimage() {
		TourImageDTO image = tourImageDAO.readWithContentid("1");
		
	
			logger.info(image.toString());

	}
	
}













