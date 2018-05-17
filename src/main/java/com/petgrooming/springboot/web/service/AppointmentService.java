package com.petgrooming.springboot.web.service;

import java.util.List;

import com.petgrooming.springboot.web.model.Appointment;
import com.petgrooming.springboot.web.model.Client;

public interface AppointmentService {
	
	public boolean saveAppointment(Appointment appointment);
	
	public List<Appointment> getAllAppointment(int client);
	
	public void updateAppointment(Appointment appointment);
}
