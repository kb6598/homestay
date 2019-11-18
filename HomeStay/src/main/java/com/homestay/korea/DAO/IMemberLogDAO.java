package com.homestay.korea.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homestay.korea.DTO.MemberLogDTO;

public interface IMemberLogDAO {

	public List<MemberLogDTO> readWithId(String id);
	public void insertMemberLog(MemberLogDTO dto);
	public List<String> readContentIdWithIds(@Param("ids")List<String> ids);
	
}
