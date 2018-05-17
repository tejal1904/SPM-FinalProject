package com.petgrooming.springboot.web.dao;

import java.util.List;

import com.petgrooming.springboot.web.model.Appointment;
import com.petgrooming.springboot.web.model.Client;

public interface AppointmentDao {
	
	public boolean saveAppointment(Appointment appointment);
	
	public List<Appointment> getAll(int client);
	
	public void update(Appointment appointment);

}
