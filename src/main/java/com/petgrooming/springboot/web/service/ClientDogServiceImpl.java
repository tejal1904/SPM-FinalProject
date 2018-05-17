package com.petgrooming.springboot.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgrooming.springboot.web.dao.ClientDogDao;
import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.ClientDog;

@Transactional
@Service("clientDogService")
public class ClientDogServiceImpl implements ClientDogService{
	
	@Autowired
	ClientDogDao clientDogDao;

	@Override
	public void saveDog(ClientDog dog) {
		clientDogDao.save(dog);
		
	}

	@Override
	public List<ClientDog> findAllDogsOfClient(int client) {
		return clientDogDao.findAllDogsByClient(client);
	}

	@Override
	public void updateDog(ClientDog dog) {
		clientDogDao.update(dog);
		
	}
	
	

}
