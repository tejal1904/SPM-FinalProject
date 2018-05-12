package com.petgrooming.springboot.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgrooming.springboot.web.dao.TimeSlotDao;
import com.petgrooming.springboot.web.model.TimeSlot;

@Service("TimeSlotService")
@Transactional
public class TimeSlotServiceImpl implements TimeSlotService{
	
	@Autowired
	TimeSlotDao timeSlotDao;

	@Override
	public List<TimeSlot> findAllTimeSlots() {
		return timeSlotDao.getAllTimeSlots();
	}

}
