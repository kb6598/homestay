package com.homestay.korea.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homestay.korea.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class TourDataSchedulingServiceTest {

	@Autowired
	private TourDataSchedulingService service;
	
	//test마무리
//	@Test
//	public void testSchedulingService() {
//		if(service.deleteTourDataForScheduling("2636166")) {
//			System.out.println("삭제 성공");
//		}
//	}
	
}
