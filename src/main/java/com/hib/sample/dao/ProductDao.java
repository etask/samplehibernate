package com.hib.sample.dao;

import java.util.List;

import com.hib.sample.model.Product;


public interface ProductDao extends AbstractHibernateDao<Product, Integer> {

	List<Product> findProductsBySupplierName(String supplierName);
	
	List<Product> findProductByName(String name);
	
	
	List getNumberOfProductsBySupplierName(String name);
	
}
