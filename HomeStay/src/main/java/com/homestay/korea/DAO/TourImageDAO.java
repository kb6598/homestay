package com.homestay.korea.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.homestay.korea.DTO.TourImageDTO;

public class TourImageDAO implements ITourImageDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final String Namespace = "com.homestay.korea.DAO.ITourImageDAO";

	@Override
	public TourImageDTO readWithContentid(String contentid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TourImageDTO> readWithThemeLimit(String theme, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	//메인화면에서 관광지 클릭 시, 상세페이지로 넘어가며 보여질 관광지 사진
	@Override
	public List<TourImageDTO> readWithPlaceDetailDataImage(TourImageDTO vo) throws Exception {
		
		return sqlSession.selectList(Namespace+".readWithPlaceDetailDataImage", vo);
	}

	@Override
	public void insertSingleTourImageRecord(TourImageDTO tourImageDTO) {
		
	}

}
