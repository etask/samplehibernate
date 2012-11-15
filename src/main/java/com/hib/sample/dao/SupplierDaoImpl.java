package com.hib.sample.dao;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.hib.sample.model.Supplier;

public class SupplierDaoImpl extends AbstractHibernateDaoImpl<Supplier, Integer> implements
		SupplierDao {

	public Supplier findSupplierByName(String name) {
		Criteria crit = getSession().createCriteria(Supplier.class);
		crit.add(Restrictions.eq("supplierName", name));
		return (Supplier) crit.uniqueResult();
	}


}
