package com.petgrooming.springboot.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.petgrooming.springboot.web.model.Client;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDAO{


	public boolean checkNewClient(Client client) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", client.getEmail()));
        criteria.add(Restrictions.eq("password", client.getPassword()));
        List<Client> clientList = criteria.list();
        if(clientList.isEmpty() || clientList.size() == 0)
        	return true;
        return false;
	}

	public void save(Client client) {
		persist(client);
	}
	
	public Client getClientById(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        List<Client> clientList = criteria.list();
        if(clientList.isEmpty() || clientList.size() == 0) {
        	return null;
        }
        return clientList.get(0);
        
	}
	
	
	public void saveOrUpdate(Client client) {
		getSession().saveOrUpdate(client);
	}

}
