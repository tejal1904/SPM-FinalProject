package com.petgrooming.springboot.web.dao;

import java.sql.Date;
import java.util.List;

import com.petgrooming.springboot.web.model.Appointment;
import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.TimeSlot;

public interface AppointmentDao {
	
	public boolean saveAppointment(Appointment appointment);
	
	public List<Appointment> getAll(int client);
	
	public boolean update(int appointmentId, Date aptDate, TimeSlot timeSlot);
	
	public List<Appointment> getAll();
	
	public List<Appointment> getAppointmentForMail();
	
	public Appointment getAppointmentById(int id);
	
	public void deleteAppointment(Appointment appointment);

}
