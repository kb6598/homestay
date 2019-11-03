package com.homestay.korea.DAO;

import java.sql.SQLException;

import com.homestay.korea.DTO.MemberDTO;

public interface IMemberDAO {
	
	public MemberDTO readWithId(String id);
	int memberInsert(MemberDTO dto) throws SQLException;
}
