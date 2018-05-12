package com.petgrooming.springboot.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.petgrooming.springboot.web.model.TimeSlot;

@Repository("timeSlotDao")
public class TimeSlotDaoImpl extends AbstractDao<Integer, TimeSlot> implements TimeSlotDao{
	
	public List<TimeSlot> getAllTimeSlots(){
		
		Criteria criteria = createEntityCriteria();
		List<TimeSlot> timeList = criteria.list();
		return timeList;
	}

}
