package com.homestay.korea.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IMemberDAO;
import com.homestay.korea.DAO.IThemePreferDAO;
import com.homestay.korea.DTO.MemberDTO;
import com.homestay.korea.DTO.ThemePreferDTO;


@Service
public class JoinMemberServiceImpl implements IJoinMemberService{

	@Autowired
	private IMemberDAO dao;
	@Autowired
	private IThemePreferDAO preferDao;
	private SqlSessionTemplate joinSqlSession;
	
	public boolean insertMember(MemberDTO dto) {
		dao.memberInsert(dto);
		return true;
	}
	@Override
	public boolean insertPrefer(ThemePreferDTO preferDto) throws SQLException {
		// TODO Auto-generated method stub
		preferDao.PreferInsert(preferDto);
		return true;
	}
	
	
	

	
}
