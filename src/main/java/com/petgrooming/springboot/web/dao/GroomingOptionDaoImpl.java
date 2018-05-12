package com.petgrooming.springboot.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.petgrooming.springboot.web.model.GroomingOption;

@Repository("groomingOptionDao")
public class GroomingOptionDaoImpl extends AbstractDao<Integer, GroomingOption> implements GroomingOptionDao{

	@Override
	public List<GroomingOption> getGroomingOptions() {
		Criteria criteria = createEntityCriteria();
		List<GroomingOption> groomingOptionList = criteria.list();
		return groomingOptionList;
	}

}
