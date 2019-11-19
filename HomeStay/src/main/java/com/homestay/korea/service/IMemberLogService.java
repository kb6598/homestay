package com.homestay.korea.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homestay.korea.DTO.MemberLogDTO;

public interface IMemberLogService {

	public List<MemberLogDTO> readWithId(String id);
	public List<String> readContentIdWithIds(List<String> ids);
	public void insertMemberLog(MemberLogDTO dto) throws SQLException;
	public void updatePrefer(@Param("theme")String theme, @Param("id")String id);
}
