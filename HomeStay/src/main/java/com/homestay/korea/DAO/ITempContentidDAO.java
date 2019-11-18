package com.homestay.korea.DAO;

import java.util.List;

public interface ITempContentidDAO {
	
	//삽입
	public void insertTempContentid(String contentId);
	
	//전체삭제
	public int deleteAllTempContentid();
	
	//place테이블과 temp_contentid테이블을 outer join하여 temp_contentid테이블에는 존재하지 않는데 place테이블에는 존재하는 관광지의 contentid를 조회
	public List<String> getDeletedContentid();
}
