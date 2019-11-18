package com.homestay.korea.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.homestay.korea.DTO.PlaceDetailDataDTO;

public class PlaceDetailDataDAO implements IPlaceDetailDataDAO {

	@Autowired
	SqlSession sqlSession;
	
	public static final String Namespace = "com.homestay.korea.DAO.IPlaceDetailDataDAO";
	
	//메인화면에서 관광지 클릭 시, 상세페이지로 넘어가며 보여질 관광지 정보
	@Override
	public List<PlaceDetailDataDTO> readWithPlaceDetailData(PlaceDetailDataDTO vo) throws Exception {
		
		return sqlSession.selectList(Namespace+".readWithPlaceDetailData", vo);
	}

	@Override
	public void insert(PlaceDetailDataDTO placeDetailDataDTO) {
		
	}
	
	public PlaceDetailDataDTO readWithPlaceDetailDataContent_value(PlaceDetailDataDTO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaceDetailDataDTO> readDetailData(String contentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteDetailData(String contentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> readTitles(List<String> contentIds) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
