package com.homestay.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IThemePreferDAO;
import com.homestay.korea.DTO.ThemePreferDTO;

@Service
public class ThemePreferReadServiceImpl implements IThemePreferReadService {
	
	@Autowired
	private IThemePreferDAO themePreferDAO;
	

	@Override
	public ThemePreferDTO getThemePrefer(String id) {
		// TODO Auto-generated method stub
		ThemePreferDTO themePrefer = themePreferDAO.readWithId(id);
		return themePrefer;
	}

	@Override
	public List<ThemePreferDTO> getThemePreferList() {
		// TODO Auto-generated method stub
		List<ThemePreferDTO> themePreferDTOList = themePreferDAO.readList();
		return themePreferDTOList;
	}

	@Override
	public List<ThemePreferDTO> getRelationThemePreferList(List<String> ids) {
		// TODO Auto-generated method stub
		List<ThemePreferDTO> themePreferDTOList = themePreferDAO.readListWithIds(ids);
		return themePreferDTOList;
	}
	
}
