package com.homestay.korea.service;

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
	
	
	
	
}




















