package com.petgrooming.springboot.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.petgrooming.springboot.web.model.AvailableDog;

@Repository("availableDogDao")
public class AvailableDogDaoImpl extends AbstractDao<Integer, AvailableDog> implements AvailableDogDao{

	@Override
	public List<AvailableDog> getAllDogs() {
		Criteria criteria = createEntityCriteria();
		List<AvailableDog> availableDogList = criteria.list();
		return availableDogList;
	}

}
