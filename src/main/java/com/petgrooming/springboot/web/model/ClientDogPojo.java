package com.petgrooming.springboot.web.model;

import java.sql.Date;

public class ClientDogPojo {
	
	private String name;
	private String breed;
	private Date dateOfBirth;
	private int clientId;
	
	public ClientDogPojo() {
		super();
	}

	public ClientDogPojo(String name, String breed, Date dateOfBirth, int clientId) {
		super();
		this.name = name;
		this.breed = breed;
		this.dateOfBirth = dateOfBirth;
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "ClientDogPojo [name=" + name + ", breed=" + breed + ", dateOfBirth=" + dateOfBirth + ", clientId="
				+ clientId + "]";
	}
	
}
