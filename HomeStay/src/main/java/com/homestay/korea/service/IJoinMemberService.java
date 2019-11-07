package com.homestay.korea.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionException;
import org.springframework.ui.Model;

import com.homestay.korea.DTO.MemberDTO;
import com.homestay.korea.DTO.ThemePreferDTO;


public interface IJoinMemberService {
	//����
//	int insertMember(MemberDTO dto) throws SQLException;
	
	boolean insertMember(MemberDTO dto) throws SQLException;
	boolean insertPrefer(ThemePreferDTO preferDto) throws SQLException;
}
