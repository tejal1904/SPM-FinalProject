package com.petgrooming.springboot.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgrooming.springboot.web.dao.AvailableDogDao;
import com.petgrooming.springboot.web.model.AvailableDog;

@Service("availableDogService")
@Transactional
public class AvailableDogServiceImpl implements AvailableDogService{
	
	@Autowired
	AvailableDogDao availableDogDao;
	
	public List<AvailableDog> findAllDogs(){
		return availableDogDao.getAllDogs();
	}

}
