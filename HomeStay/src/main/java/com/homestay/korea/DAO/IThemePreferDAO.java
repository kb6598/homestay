package com.homestay.korea.DAO;

import java.util.List;

import com.homestay.korea.DTO.ThemePreferDTO;

public interface IThemePreferDAO {
	public ThemePreferDTO readWithId(String id);
	public List<ThemePreferDTO> readListWithId(); //연령대, 동반인 등 매개변수 추가해야함 xml도 같이바꿔주세요~
}
