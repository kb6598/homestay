package com.homestay.korea.service;

import java.util.List;

import com.homestay.korea.DTO.ThemePreferDTO;

public interface IThemePreferReadService {
	public ThemePreferDTO getThemePrefer(String id);
	public List<ThemePreferDTO> getThemePreferList(); //DAO에 매개변수 추가하면 여기다가도 추가해줘야함
	public List<ThemePreferDTO> getRelationThemePreferList(List<String> ids);
}
