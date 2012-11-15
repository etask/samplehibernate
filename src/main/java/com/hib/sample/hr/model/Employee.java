package com.hib.sample.hr.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="EMPLOYEES", uniqueConstraints={@UniqueConstraint(columnNames="EMAIL")})
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Employee {

	@Id
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	
	@Column(nullable=false,name="FIRST_NAME")
	private String firstName;
	
	@Column(nullable=false,name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	@Email
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	@Column(nullable=false,name="HIRE_DATE")
	private java.util.Date hireDate;
	
	@JoinColumn(name="JOB_ID")
	@OneToOne(optional=false, fetch=FetchType.LAZY)
	private Job job;

	@Column(name="SALARY")
	@Check(constraints = "salary > 1")
	@Min(value=1,message = "salary must be > 1")
	private BigDecimal salary;
	
	@Column(name="COMMISSION_PCT")
	private BigDecimal commissionPct;
	
	@JoinColumn(name="MANAGER_ID")
	@ManyToOne(optional=true)
	private Employee manager;
	
	@OneToMany(mappedBy = "manager")
	private Set<Employee> employeesToManage = new HashSet<Employee>();	

	@JoinColumn(name="DEPARTMENT_ID")
	@OneToOne(optional=true, fetch=FetchType.LAZY)
	private Department department;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public java.util.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = hireDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getEmployeesToManage() {
		return employeesToManage;
	}

	public void setEmployeesToManage(Set<Employee> employeesToManage) {
		this.employeesToManage = employeesToManage;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department departmentId) {
		this.department = departmentId;
	}


	
	
}
