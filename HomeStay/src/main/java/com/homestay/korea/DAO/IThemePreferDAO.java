package com.homestay.korea.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homestay.korea.DTO.ThemePreferDTO;

public interface IThemePreferDAO {
	public ThemePreferDTO readWithId(String id);
	public List<ThemePreferDTO> readListWithIds(@Param("id")List<String> id);
	public List<ThemePreferDTO> readList();
	public void PreferInsert(ThemePreferDTO dto);
	public void updatePrefer(@Param("theme")String theme, @Param("id")String id);
}
