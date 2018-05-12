package com.petgrooming.springboot.web.service;

import java.util.List;

import com.petgrooming.springboot.web.model.TimeSlot;

public interface TimeSlotService {
	
	public List<TimeSlot> findAllTimeSlots();

}
