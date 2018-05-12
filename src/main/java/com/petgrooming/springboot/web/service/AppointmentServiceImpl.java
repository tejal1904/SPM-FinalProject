package com.petgrooming.springboot.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgrooming.springboot.web.dao.AppointmentDao;
import com.petgrooming.springboot.web.model.Appointment;

@Service("appointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentDao appointmentDao;

	@Override
	public void saveAppointment(Appointment appointment) {
		appointmentDao.saveAppointment(appointment);
	}
	
	

}
