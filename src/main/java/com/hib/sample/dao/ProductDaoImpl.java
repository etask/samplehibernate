package com.hib.sample.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hib.sample.model.Product;

public class ProductDaoImpl extends AbstractHibernateDaoImpl<Product, Integer> implements
		ProductDao {

	@SuppressWarnings("unchecked")
	public List<Product> findProductsBySupplierName(String supplierName) {
		Criteria crit = getSession().createCriteria(Product.class);
		//Criteria suppCrit = crit.createCriteria("supplier");
		//suppCrit.add(Restrictions.eq("supplierName",supplierName));
		//List results = crit.list();
		//
		
		crit.createAlias("supplier", "s").add(Restrictions.eq("s.supplierName", supplierName));
		List list = crit.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Product> findProductByName(String name) {
		Criteria crit = getSession().createCriteria(Product.class);
		
		Criterion productName = Restrictions.like("productDetails.productName", name);
		
		crit.add(productName);
	
		return crit.list();
	}

	public List getNumberOfProductsBySupplierName(String name) {
		Criteria crit = getSession().createCriteria(Product.class);
		crit.setProjection(Projections.rowCount());
		crit.createAlias("supplier", "s").add(Restrictions.eq("s.supplierName", name));
		return crit.list();
	}

}
