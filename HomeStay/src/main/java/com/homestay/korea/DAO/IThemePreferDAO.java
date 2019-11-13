package com.homestay.korea.DAO;

import java.util.List;

import com.homestay.korea.DTO.ThemePreferDTO;

public interface IThemePreferDAO {
	public ThemePreferDTO readWithId(String id);
	public List<ThemePreferDTO> readListWithIds(List<String> id);
	public List<ThemePreferDTO> readList();
	public void PreferInsert(ThemePreferDTO dto);
}
