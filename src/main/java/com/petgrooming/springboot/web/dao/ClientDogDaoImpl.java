package com.petgrooming.springboot.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.ClientDog;

@Repository("ClientDogDao")
public class ClientDogDaoImpl extends AbstractDao<Integer, ClientDog> implements ClientDogDao{
	
	public void save(ClientDog clientDog) {
		persist(clientDog);
	}

	@Override
	public List<ClientDog> findAllDogsByClient(int client) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("client.id", client));
		List<ClientDog> result = criteria.list();
		return result;
	}

	@Override
	public void update(ClientDog clientdog) {
		getSession().update(clientdog);
		
	}

}
