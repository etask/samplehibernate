package com.hib.sample.hr.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Department {
	
	@Id
	@Column(name="DEPARTMENT_ID")
	private int departmentId;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@JoinColumn(name="MANAGER_ID")
	@OneToOne(optional=true)
	private Employee departmentManager;
	
	@OneToMany(mappedBy="department")
	private Set<Employee> employees = new HashSet<Employee>();
	
	@JoinColumn(name="LOCATION_ID")
	@OneToOne(fetch=FetchType.LAZY)
	private Location location;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(Employee departmentManager) {
		this.departmentManager = departmentManager;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	
	
	


}
