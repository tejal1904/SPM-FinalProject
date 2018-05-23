package com.petgrooming.springboot.web.service;

import java.sql.Date;
import java.util.List;

import com.petgrooming.springboot.web.model.Appointment;
import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.TimeSlot;

public interface AppointmentService {
	
	public boolean saveAppointment(Appointment appointment);
	
	public List<Appointment> getAllAppointment(int client);
	
	public List<Appointment> getAllAppointment();
	
	public boolean updateAppointment(int appointmentId, Date aptDate, TimeSlot timeSlot);
	
	public List<Appointment> getAppointmentForMail();
	
	public Appointment getAppointmentById(int id);
	
	public void deleteAppointment(Appointment appointment);
}
