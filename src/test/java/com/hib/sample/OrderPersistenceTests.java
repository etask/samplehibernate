package com.hib.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hib.sample.dao.SupplierDao;
import com.hib.sample.dao.hr.DepartmentDao;
import com.hib.sample.dao.hr.EmployeeDao;
import com.hib.sample.model.Supplier;
import com.hib.sample.utils.HibernateUtils;
import com.hib.sample.utils.RecordUtils;
import com.sample.dao.inheritance.Account;
import com.sample.dao.inheritance.SavingsAccountDao;
import com.sample.dao.inheritance.CheckingAccount;
import com.sample.dao.inheritance.SavingsAccount;



@ContextConfiguration//(locations = {"classpath*:OrderPersistenceTests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OrderPersistenceTests {


	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	Configuration hibernateConfiguration;
	
	private Supplier supplier;
	
	private RecordUtils recordUtils;
	
	@Autowired
	private SavingsAccountDao accountDao;

	@Before
	public void setUp(){
	
	}
	
	
	
	@Test
	public void sql_1()
	{
		//List l = employeeDao.getEmployeesAndManagers();
		/*Employee e;
		Department d;
		Object[] temp = new Object[3];
		List<Object[]> res = new ArrayList<Object[]>();
		System.out.println("\n\n\n\nRESULTS\n\n\n\n\n\n");
		for (Object o : l)
		{
			
			temp = (Object[]) o;
			e = (Employee)temp[0];
			System.out.println("employee: "+e.getFirstName()+" "+e.getLastName());
			e = (Employee)temp[1];
			System.out.println("has manager: "+e.getFirstName()+" "+e.getLastName());
			d = (Department) temp[2];
			System.out.println("on department: "+d.getDepartmentName());
			break;
		}*/
		
		//Employee t = employeeDao.findById(100, false);
		//Department d = departmentDao.findAll().get(0);
		//System.out.println("department manager: "+d.getDepartmentManager().getEmployeeId());
		//System.out.println(e.getDepartment().getDepartmentId());
		//System.out.println("number of employees managed by SKING: "+e.getEmployeesToManage().size());
		
		SavingsAccount sa = new SavingsAccount();
		sa.setCreationDate(new Date());
		sa.setInterestRate(new Long(10));
		sa.setBalance(new Long(50));
		
	/*	CheckingAccount ca = new CheckingAccount();
		ca.setBalance(new Long(1000));
		ca.setCheckStyle("cS");
		ca.setCreationDate(new Date());*/
		
		
		accountDao.makePersistent(sa);
		//accountDao.makePersistent(ca);
		
		
		//List<Account> accounts = accountDao.findAll();	
		
		SavingsAccount s = (SavingsAccount) accountDao.findAll().get(0);
		//CheckingAccount c = (CheckingAccount) accounts.get(1);
		
		System.out.println("OUTPUT");
		System.out.println(s.getAccountId()+"\t"+s.getBalance()+"\t"+s.getInterestRate()+"\t");
	}

	
	//@Test
	public void testSchema() {
		HibernateUtils hUtils = new HibernateUtils(hibernateConfiguration);
		hUtils.generateSchema();
		
		assertTrue(true);
	}
	
	//@Test
	//@Rollback
	public void temp()
	{
		
		
		/*Set<ConstraintViolation<Object>> constraintViolations = HibernateValidatorUtils.getConstraintViolations(emp);
		assertEquals(1,constraintViolations.size());*/
		//assertEquals("salary must be > 1",constraintViolations.iterator().next().getMessage());
		
		assertEquals("King",employeeDao.findById(100, true).getLastName());
		
		
	}
	
	

	//@Test	
	//@Rollback(true)
	public void insertAtImmutableClass()
	{
		
		
		Supplier expected = supplierDao.findSupplierByName("supplierOne");
		
		assertEquals("supplierOne",expected.getSupplierName());
		assertEquals(2,supplierDao.findAll().size());
		
		
		
	}
	
	
	//@Test
	public void testRecordUtils()
	{
		assertEquals(2, supplierDao.findAll().size());
		assertEquals(3, supplierDao.findAll().get(0).getProducts().size());
		assertEquals(3, supplierDao.findAll().get(1).getProducts().size());
	}
	//@Test
	//@Rollback(true)
	public void deleteAtImmutableClass()
	{
		
		Supplier expected = supplierDao.findSupplierByName("supplierOne");
		supplierDao.makeTransient(expected);
		
		expected = supplierDao.findSupplierByName("supplierOne");
		assertNull(expected);
	}
	
	
	//@Test
	//@Rollback(true)
	//@ExpectedException(HibernateException.class)
	public void updateAtImmutableClass()
	{

		Supplier expected = supplierDao.findSupplierByName("supplierOne");
		assertEquals("supplierOne",expected.getSupplierName());
		//assertEquals(15,expected.getSupplierId());
		expected.setSupplierName("updatedSupplier");
		supplierDao.makePersistent(expected);
		
		for (Supplier x: supplierDao.findAll())
		{
			System.out.println("supplierId: "+x.getSupplierId()+" supplierName: "+x.getSupplierName());
		}
		
		
		System.out.println("\nbefore\n");
		Supplier temp = supplierDao.findSupplierByName("updatedSupplier");
		System.out.println("\nafter\n");
		assertNull(temp);
		Supplier temp2 = supplierDao.findSupplierByName("supplierOne");
		assertNotNull(temp2);
		System.out.println("supplierId: "+temp2.getSupplierId()+" supplierName: "+temp2.getSupplierName());
		//assertEquals("supplierOne",temp2.getSupplierName());
		
		Supplier temp3 = supplierDao.findAll().get(0);
		assertNotNull(temp3);
		System.out.println("supplierId: "+temp3.getSupplierId()+" supplierName: "+temp3.getSupplierName());
		assertEquals("supplierOne",temp3.getSupplierName());
		
		//assertEquals("updatedSupplier",supplierDao.findSupplierByName("updatedSupplier").getSupplierName());
		
		//Supplier x = supplierDao.findSupplierByName("supplierOne");
		
		//assertEquals("updatedSupplier",s.getSupplierName());
		//assertEquals("updatedSupplier",x.getSupplierName());
	}
	
	

	
	
	

	

}
