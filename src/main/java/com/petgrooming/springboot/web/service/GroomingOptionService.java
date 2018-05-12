package com.petgrooming.springboot.web.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.petgrooming.springboot.web.model.GroomingOption;


public interface GroomingOptionService {
	public List<GroomingOption> getGroomingOptions();

}
