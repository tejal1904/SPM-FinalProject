package com.petgrooming.springboot.web.dao;

import com.petgrooming.springboot.web.model.Client;

public interface ClientDAO {

	public boolean checkNewClient(Client client);

	public void save(Client client);
	
	public Client getClientById(int id); 

}
