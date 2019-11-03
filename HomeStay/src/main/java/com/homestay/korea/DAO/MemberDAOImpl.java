package com.homestay.korea.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.homestay.korea.DTO.MemberDTO;


public class MemberDAOImpl implements IMemberDAO{

	@Inject
	private SqlSession sqlsession;

	
	
	@Override
	public MemberDTO readWithId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberDTO memberdto) {
		// TODO Auto-generated method stub
		sqlsession.insert("insertMember",memberdto);
	}

	
}
