package com.petgrooming.springboot.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="GROOMINGOPTION")
public class GroomingOption {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GROOMING_ID")
    private int groomingId;
	
	@Size(min=3, max=50)
    @Column(name = "GROOMINGTYPE", nullable = true)
	private String groomingType;
	
    @Column(name = "COST", nullable = true)
	private float cost;

	public int getGroomingId() {
		return groomingId;
	}

	public void setGroomingId(int groomingId) {
		this.groomingId = groomingId;
	}

	public String getGroomingType() {
		return groomingType;
	}

	public void setGroomingType(String groomingType) {
		this.groomingType = groomingType;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + groomingId;
		result = prime * result + ((groomingType == null) ? 0 : groomingType.hashCode());
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
		GroomingOption other = (GroomingOption) obj;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (groomingId != other.groomingId)
			return false;
		if (groomingType == null) {
			if (other.groomingType != null)
				return false;
		} else if (!groomingType.equals(other.groomingType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroomingOption [groomingId=" + groomingId + ", groomingType=" + groomingType + ", cost=" + cost + "]";
	}
	
    
	

}
