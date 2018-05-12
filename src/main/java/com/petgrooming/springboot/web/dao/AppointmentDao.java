package com.petgrooming.springboot.web.dao;

import com.petgrooming.springboot.web.model.Appointment;

public interface AppointmentDao {
	
	public boolean saveAppointment(Appointment appointment);

}
