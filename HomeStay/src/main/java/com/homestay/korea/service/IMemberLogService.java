package com.homestay.korea.service;

import java.sql.SQLException;
import java.util.List;

import com.homestay.korea.DTO.MemberLogDTO;

public interface IMemberLogService {

	public List<MemberLogDTO> readWithId(String id);
	public void insertMemberLog(MemberLogDTO dto) throws SQLException;
}
