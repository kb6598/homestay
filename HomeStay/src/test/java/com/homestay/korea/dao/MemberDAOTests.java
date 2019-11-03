package com.homestay.korea.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homestay.korea.DAO.IMemberDAO;
import com.homestay.korea.DTO.MemberDTO;
import com.homestay.korea.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class MemberDAOTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IMemberDAO memberDAO;
	
	//test 마무리
//	@Test
//	public void testReadMember() {
//		MemberDTO member = memberDAO.readWithId("seunghyun11");
//		logger.info(member.toString());
//	}
	
	//test 마무리
//	@Test
//	public void testInsertMember() {
//		MemberDTO member = new MemberDTO();
//		member.setAge("11");
//		member.setCompanion("친구");
//		member.setGender("m");
//		member.setId("nowonhoㅄ");
//		member.setName("노원호");
//		member.setNation(410);
//		member.setPhone("010-1234-1234");
//		member.setPw("1234");
//		member.setRegional("경기");
//		
//		memberDAO.memberInsert(member);
//	}
}













