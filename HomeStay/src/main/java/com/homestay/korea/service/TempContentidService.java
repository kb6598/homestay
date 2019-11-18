package com.homestay.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.ITempContentidDAO;

@Service
public class TempContentidService {
	
	@Autowired
	private ITempContentidDAO tempContentidDao;
	
	public void insertTempContntid(String contentId) {
		tempContentidDao.insertTempContentid(contentId);
	}
	
	public int truncateTempContntid() {
		return tempContentidDao.deleteAllTempContentid();
	}
	
	public List<String> getDeletedContentid(){
		return tempContentidDao.getDeletedContentid();
	}
	
}
