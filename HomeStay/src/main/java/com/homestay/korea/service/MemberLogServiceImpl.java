package com.homestay.korea.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IMemberLogDAO;
import com.homestay.korea.DTO.MemberLogDTO;

@Service
public class MemberLogServiceImpl implements IMemberLogService {

	@Autowired
	private IMemberLogDAO memberLogDAO;
	
	@Override
	public List<MemberLogDTO> readWithId(String id) {
		List<MemberLogDTO> memberLog = memberLogDAO.readWithId(id);
		return memberLog;
	}

	@Override
	public void insertMemberLog(MemberLogDTO dto) throws SQLException {
		memberLogDAO.insertMemberLog(dto);
	}

}
