package com.petgrooming.springboot.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgrooming.springboot.web.dao.ClientDAO;
import com.petgrooming.springboot.web.model.Client;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	public boolean isNewClient(Client client) {
		return clientDAO.checkNewClient(client);
	}

	public void saveNewClient(Client client) {
		clientDAO.save(client);
	}

	@Override
	public Client findClientById(int id) {
		return clientDAO.getClientById(id);
	}

	@Override
	public void saveOrUpdateClient(Client client) {
		clientDAO.saveOrUpdate(client);
	}
}
