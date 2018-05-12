package com.petgrooming.springboot.web.dao;

import org.springframework.stereotype.Repository;

import com.petgrooming.springboot.web.model.Appointment;

@Repository("appointmentDao")
public class AppointlemtDaoImpl extends AbstractDao<Integer, Appointment> implements AppointmentDao{

	@Override
	public void saveAppointment(Appointment appointment) {
		persist(appointment);
	}

}
