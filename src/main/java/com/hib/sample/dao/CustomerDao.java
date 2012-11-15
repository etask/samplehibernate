package com.hib.sample.dao;

import java.util.List;

import com.hib.sample.model.Customer;

public interface CustomerDao {

	
	void saveEmployee(Customer entity);
	List<Customer> getAllEmployees();
	Customer findEmployeeById(Integer id);
	Customer findEmployeeBySurame(String surname);
	
}
