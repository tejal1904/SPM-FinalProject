package com.petgrooming.springboot.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.petgrooming.springboot.web.model.Appointment;

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

}
