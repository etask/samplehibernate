package com.hib.sample.dao.hr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;

import com.hib.sample.dao.AbstractHibernateDaoImpl;
import com.hib.sample.hr.model.Employee;
import com.hib.sample.hr.model.EmployeeManagerResult;

public class EmployeeDaoImpl extends AbstractHibernateDaoImpl<Employee, Integer> implements
		EmployeeDao {

	
	
	
	/*public Map<Employee, List<Employee>> getEmployeesAndManagers() {
		Map<Employee, List<Employee>> results = new HashMap<Employee, List<Employee>>();
		
		Query query = getSession().createQuery("from Employee e1, Employee e2, Department d where " +
												"e1.managerId=e2.employeeId and e1.departmentId = d.departmentId;");
		
		query.list();
		return null;
	}*/

	public List getEmployeesAndManagers() {
		Map<Employee, List<Employee>> results = new HashMap<Employee, List<Employee>>();
		
/*		Query query = getSession().createQuery("from Employee e1, Employee e2, Department d where " +
												"e1.manager=e2.employeeId and e1.departmentId = d.departmentId" +
												" and e1.email='SKING'");
*/		
		Query query = getSession().createSQLQuery(
				"select e1.lastName,e2.lastName,d.departmentName" +
				" from Employee e1 left outer join Employee e2 on (e1.manager = e2.employeeId)" +
				" inner join Department d on (e1.departmentId = d.departmentId)" +
				" where e1.email='JKING'");
		

		EmployeeManagerResult emr = (EmployeeManagerResult) query.list().get(0);
		//System.out.println("emp: "+emr.getEmployeeName()+" with manager: -- on dept: "+emr.getDeptName()	);
		
		return query.list();
	}
	
	public int getNumOfEmployeesByManager()
	{
		
		Query query = getSession().createQuery(
				" select e2.firstName,e2.lastName, count(e1.employeeId) " +
				" from Employee as e1, Employee as e2" +
				" where e1.manager = e2.employeeId" +
				" and e1.manager = 100"+
				" group by e2.firstName,e2.lastName");
		
		
		return query.list().size();
	}



}
