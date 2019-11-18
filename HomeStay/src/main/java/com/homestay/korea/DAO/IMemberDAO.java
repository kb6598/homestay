package com.homestay.korea.DAO;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homestay.korea.DTO.MemberDTO;

public interface IMemberDAO {
	
	public MemberDTO readWithId(String id);
	public void memberInsert(MemberDTO dto);
	public List<String> readRelationId(@Param("contentId") String contentId,
										@Param("gender")String gender,
										@Param("age")String age,
										@Param("companion")String companion);
	
	
	
}
