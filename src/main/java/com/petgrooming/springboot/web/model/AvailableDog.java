package com.petgrooming.springboot.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AVAILABLEDOG")
public class AvailableDog {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOG_ID")
    private int DogId;
	
	@Column(name = "BREED")
	private String breed;

	public int getDogId() {
		return DogId;
	}

	public void setDogId(int dogId) {
		DogId = dogId;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + DogId;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
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
		AvailableDog other = (AvailableDog) obj;
		if (DogId != other.DogId)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AvailableDog [DogId=" + DogId + ", breed=" + breed + "]";
	}

	
}
