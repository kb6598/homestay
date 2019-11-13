package com.homestay.korea.DAO;

import java.sql.SQLException;
import java.util.List;

import com.homestay.korea.DTO.MemberDTO;

public interface IMemberDAO {
	
	public MemberDTO readWithId(String id);
	public void memberInsert(MemberDTO dto);
	public List<String> readRelationId(String contentId, String gender, String age, String companion);
	
}
