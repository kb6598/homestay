package com.homestay.korea.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homestay.korea.DAO.ITempContentidDAO;
import com.homestay.korea.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class TempContentidDAOTests {
	
	@Autowired
	private ITempContentidDAO tempContentidDao;
	
	//test 마무리
//	@Test
//	public void testInsert() {
//		tempContentidDao.insertTempContentid("1234");
//	}
	
	//test마무리
//	@Test
//	public void testTruncate() {
//		tempContentidDao.deleteAllTempContentid();
//	}
	
	//test 마무리
//	@Test
//	public void testJoin() {
//		List<String> list = tempContentidDao.getDeletedContentid();
//		list.forEach(str->{
//			System.out.println("삭제된 관광지의 contentid:"+str);
//		});
//	}

}





















