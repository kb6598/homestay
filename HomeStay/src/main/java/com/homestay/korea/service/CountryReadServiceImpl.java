package com.homestay.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.korea.DAO.ICountryDAO;
import com.homestay.korea.DTO.CountryDTO;

@Service
public class CountryReadServiceImpl implements ICountryReadService {

	@Autowired
	private ICountryDAO countryDAO;

	@Override
	public List<CountryDTO> countryList() {
		// TODO Auto-generated method stub
		return countryDAO.countryList();
	}

}

