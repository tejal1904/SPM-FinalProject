package com.petgrooming.springboot.web.service;

import java.util.List;

import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.ClientDog;

public interface ClientDogService {
	
	public void saveDog(ClientDog dog);
	
	public List<ClientDog> findAllDogsOfClient(Client client);

}
