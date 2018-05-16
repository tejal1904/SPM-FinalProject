package com.petgrooming.springboot.web.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="CLIENTDOG")
public class ClientDog {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENT_DOG_ID")
    private int clientDogId;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="CLIENT_ID")
	private Client client;
	
	@Size(min=3, max=50)
    @Column(name = "NAME", nullable = true)
	private String name;
	
	@Size(min=3, max=50)
    @Column(name = "BREED", nullable = true)
	private String breed;
	
    @Column(name = "DOB", nullable = true)
	private Date dateOfBirth;

	public int getId() {
		return clientDogId;
	}

	public void setId(int id) {
		this.clientDogId = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + clientDogId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ClientDog other = (ClientDog) obj;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (clientDogId != other.clientDogId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientDog [id=" + clientDogId + ", client=" + client + ", name=" + name + ", breed=" + breed + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
    
    

}
