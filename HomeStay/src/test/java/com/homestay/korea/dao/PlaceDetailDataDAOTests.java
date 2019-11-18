package com.homestay.korea.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homestay.korea.DAO.IPlaceDetailDataDAO;
import com.homestay.korea.DTO.PlaceDetailDataDTO;
import com.homestay.korea.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class PlaceDetailDataDAOTests {

	@Autowired
	private IPlaceDetailDataDAO dao;
	
	
	//테스트 마무리
//	@Test
//	public void testInsert() {
//		PlaceDetailDataDTO dto = new PlaceDetailDataDTO();
//		dto.setContent_category("테스트칼럼");
//		dto.setContentid("테스트contentid");
//		dto.setContent("테스트content");
//		
//		dao.insert(dto);
//	}
	
//	@Test
//	public void testRead() {	
//		List<PlaceDetailDataDTO> dto = dao.readDetailData("990539");
//		System.out.println(dto);
//	}
	
	
}


















