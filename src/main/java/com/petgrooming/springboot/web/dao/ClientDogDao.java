package com.petgrooming.springboot.web.dao;

import java.util.List;

import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.ClientDog;

public interface ClientDogDao {
	
	public void save(ClientDog clientDog);
	
	public List<ClientDog> findAllDogsByClient(int client);
	
	public void update(ClientDog clientdog, Client client);
	
	public ClientDog findById(int id);

}
