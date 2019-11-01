package com.homestay.korea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.IMemberDAO;
import com.homestay.korea.DTO.MemberDTO;

@Service
public class MemberExistsService {
	
	@Autowired
	private IMemberDAO memberDAO;
	
	public boolean isExistsId(String id) {
		MemberDTO member = memberDAO.readWithId(id);
		if(member == null)
			return false;
		return true;
	}
	
}
