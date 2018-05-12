package com.petgrooming.springboot.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIMESLOT")
public class TimeSlot {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIMESLOT_ID")
    private int timeSlotId;
	
	@Column(name = "TIMESTART")
	private float timeStart;

	public int getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(int timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public float getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(float timeStart) {
		this.timeStart = timeStart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + timeSlotId;
		result = prime * result + Float.floatToIntBits(timeStart);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeSlot other = (TimeSlot) obj;
		if (timeSlotId != other.timeSlotId)
			return false;
		if (Float.floatToIntBits(timeStart) != Float.floatToIntBits(other.timeStart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TimeSlot [timeSlotId=" + timeSlotId + ", timeStart=" + timeStart + "]";
	}
	

}
