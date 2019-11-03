package com.homestay.korea.DAO;

import com.homestay.korea.DTO.MemberDTO;

public interface IMemberDAO {
	
	public MemberDTO readWithId(String id);
	public void insertMember(MemberDTO memberdto);
}
