package com.petgrooming.springboot.web.service;

import java.util.List;

import com.petgrooming.springboot.web.model.AvailableDog;

public interface AvailableDogService{
	
	public List<AvailableDog> findAllDogs();

}
