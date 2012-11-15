package com.hib.sample.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hib.sample.model.Customer;


public class CustomerDaoImpl extends AbstractHibernateDaoImpl<Customer, Integer>
		implements CustomerDao {

	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public void saveEmployee(Customer entity) {
		makePersistent(entity);
	}

	public List<Customer> getAllEmployees() {
		
		return findAll();
	}

	public Customer findEmployeeById(Integer id) {
		
		return findById(id, true);
	}

	public Customer findEmployeeBySurame(String surname) {
		
		return null;
	}

	

}
