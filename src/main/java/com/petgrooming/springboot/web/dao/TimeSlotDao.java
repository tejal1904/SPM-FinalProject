package com.petgrooming.springboot.web.dao;

import java.util.List;

import com.petgrooming.springboot.web.model.TimeSlot;

public interface TimeSlotDao {
	
	public List<TimeSlot> getAllTimeSlots();
	
	public TimeSlot getById(int id);

}
