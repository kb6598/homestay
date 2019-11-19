package com.homestay.korea.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IMemberLogDAO;
import com.homestay.korea.DAO.IThemePreferDAO;
import com.homestay.korea.DTO.MemberLogDTO;

@Service
public class MemberLogServiceImpl implements IMemberLogService {

	@Autowired
	private IMemberLogDAO memberLogDAO;
	
	@Autowired
	private IThemePreferDAO themePreferDAO;
	
	@Override
	public List<MemberLogDTO> readWithId(String id) {
		List<MemberLogDTO> memberLog = memberLogDAO.readWithId(id);
		return memberLog;
	}

	@Override
	public void insertMemberLog(MemberLogDTO dto) throws SQLException {
		memberLogDAO.insertMemberLog(dto);
	}

	@Override
	public List<String> readContentIdWithIds(List<String> ids) {
		List<String> contentIds =memberLogDAO.readContentIdWithIds(ids);
		return contentIds;
	}

	@Override
	public void updatePrefer(String theme, String id) {
		String themeEng="";
		switch (theme) {
		case "관광지":
			themeEng="tour_attr";
			break;
		case "문화시설":
			themeEng="cult_facil";
			break;
		case "행사/공연/축제":
			themeEng="event";
			break;
		case "쇼핑":
			themeEng="shopping";
			break;
		case "레포츠":
			themeEng="leports";
			break;
		case "음식점":
			themeEng="dining";
			break;
		default:
			break;
		}
		themePreferDAO.updatePrefer(themeEng, id);
	}

}
