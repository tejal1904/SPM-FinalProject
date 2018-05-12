package com.petgrooming.springboot.web.service;

import com.petgrooming.springboot.web.model.Client;

public interface ClientService {

	boolean isNewClient(Client client);

	void saveNewClient(Client client);
	
	public Client findClientById(int id);
	
	public void saveOrUpdateClient(Client client);

}
