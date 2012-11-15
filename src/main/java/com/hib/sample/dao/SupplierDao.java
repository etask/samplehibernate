package com.hib.sample.dao;

import com.hib.sample.model.Supplier;


public interface SupplierDao extends AbstractHibernateDao<Supplier, Integer>{

	Supplier findSupplierByName(String name);
}
