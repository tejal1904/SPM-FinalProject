package com.petgrooming.springboot.web.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.petgrooming.springboot.web.model.Appointment;
import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.TimeSlot;

@Repository("appointmentDao")
public class AppointlemtDaoImpl extends AbstractDao<Integer, Appointment> implements AppointmentDao{

	@Override
	public boolean saveAppointment(Appointment appointment) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("timeslot", appointment.getTimeslot()));
		criteria.add(Restrictions.eq("appointmentDate", appointment.getAppointmentDate()));
		List<Appointment> appointmentList = criteria.list();
		if(appointmentList.isEmpty() && appointmentList.size() == 0) {
			persist(appointment);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<Appointment> getAll(int client) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("client.id", client));
		List<Appointment> appointmentList = criteria.list();
		return appointmentList;
	}

	@Override
	public boolean update(int appointmentId, Date aptDate, TimeSlot timeSlot) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("timeslot", timeSlot));
		criteria.add(Restrictions.eq("appointmentDate", aptDate));
		criteria.add(Restrictions.ne("appointmentId", appointmentId));
		List<Appointment> appointmentList = criteria.list();
		if(appointmentList.isEmpty() && appointmentList.size() == 0) {
			Appointment appointment = getByKey(appointmentId);
			appointment.setAppointmentDate(aptDate);
			appointment.setTimeslot(timeSlot);
			getSession().update(appointment);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Appointment> getAll() {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.ge("appointmentDate", date));
		List<Appointment> appointmentList = criteria.list();
		return appointmentList;
	}

	@Override
	public List<Appointment> getAppointmentForMail() {
		java.sql.Date now = new java.sql.Date( new java.util.Date().getTime() );
		java.sql.Date tomorrow= new java.sql.Date( now.getTime() + 24*60*60*1000);
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("appointmentDate", tomorrow));
		List<Appointment> appointmentList = criteria.list();
		return appointmentList;	
		}
	
	public Appointment getAppointmentById(int id) {
		return getByKey(id);
	}

}
