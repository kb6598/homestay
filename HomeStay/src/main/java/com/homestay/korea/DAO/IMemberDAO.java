package com.homestay.korea.DAO;

import java.sql.SQLException;

import com.homestay.korea.DTO.MemberDTO;

public interface IMemberDAO {
	
	public MemberDTO readWithId(String id);
	public void memberInsert(MemberDTO dto);
	
}
