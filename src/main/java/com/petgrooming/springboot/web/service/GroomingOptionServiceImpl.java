package com.petgrooming.springboot.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgrooming.springboot.web.dao.GroomingOptionDao;
import com.petgrooming.springboot.web.model.GroomingOption;

@Service("groomingOptionService")
@Transactional
public class GroomingOptionServiceImpl implements GroomingOptionService{
	
	@Autowired
	GroomingOptionDao groomingOptionDao;

	@Override
	public List<GroomingOption> getGroomingOptions() {
		return groomingOptionDao.getGroomingOptions();
	}
	
	

}
