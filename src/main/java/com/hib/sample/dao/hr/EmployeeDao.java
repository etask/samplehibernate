package com.hib.sample.dao.hr;

import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.hib.sample.dao.AbstractHibernateDao;
import com.hib.sample.hr.model.Employee;

public interface EmployeeDao extends AbstractHibernateDao<Employee, Integer>{

	//Map<Employee,List<Employee>> getEmployeesAndManagers();
	List getEmployeesAndManagers();
	int getNumOfEmployeesByManager();
}
