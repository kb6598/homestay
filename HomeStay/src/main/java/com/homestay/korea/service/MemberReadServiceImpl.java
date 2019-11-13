package com.homestay.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IMemberDAO;
import com.homestay.korea.DTO.MemberDTO;

@Service
public class MemberReadServiceImpl implements IMemberReadService {
	
	@Autowired
	private IMemberDAO memberDAO;

	@Override
	public MemberDTO getMember(String id) {
		MemberDTO member = memberDAO.readWithId(id);
		return member;
	}

	@Override
	public List<String> getRelationId(String contentId, String gender, String age, String companion) {
		List<String> relationIds= memberDAO.readRelationId(contentId, gender, age, companion);
		return relationIds;
	}
	
}




















