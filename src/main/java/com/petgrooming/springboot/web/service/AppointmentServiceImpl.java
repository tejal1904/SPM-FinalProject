package com.petgrooming.springboot.web.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgrooming.springboot.web.dao.AppointmentDao;
import com.petgrooming.springboot.web.model.Appointment;
import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.TimeSlot;

@Service("appointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentDao appointmentDao;

	@Override
	public boolean saveAppointment(Appointment appointment) {
		return appointmentDao.saveAppointment(appointment);
	}

	@Override
	public List<Appointment> getAllAppointment(int client) {
		return appointmentDao.getAll(client);
	}
	
	@Override
	public List<Appointment> getAllAppointment() {
		return appointmentDao.getAll();
	}

	@Override
	public boolean updateAppointment(int appointmentId, Date aptDate, TimeSlot timeSlot) {
		return appointmentDao.update(appointmentId, aptDate, timeSlot);
	}

	@Override
	public List<Appointment> getAppointmentForMail() {
		return appointmentDao.getAppointmentForMail();
	}

	@Override
	public Appointment getAppointmentById(int id) {
		return appointmentDao.getAppointmentById(id);
	}

	@Override
	public void deleteAppointment(Appointment appointment) {
		appointmentDao.deleteAppointment(appointment);
		
	}
	
	
	

}
