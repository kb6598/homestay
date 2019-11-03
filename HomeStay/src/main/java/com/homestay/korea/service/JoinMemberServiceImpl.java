package com.homestay.korea.service;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IMemberDAO;
import com.homestay.korea.DTO.MemberDTO;


@Service
public class JoinMemberServiceImpl implements IJoinMemberService {

	@Inject
	private IMemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberDTO memberdto) {
		memberDAO.insertMember(memberdto);
	}
	
	


//	@Override
//	public void insertMemmber_theme(Theme_prefer prefer) {
//		// TODO Auto-generated method stub
//		
//	}
	

	
}
