package com.homestay.korea.service;

import java.util.List;

import com.homestay.korea.DTO.MemberDTO;

public interface IMemberReadService {
	
	public MemberDTO getMember(String id);
	public List<String> getRelationId(String contentId, String gender, String age, String companion);
}
