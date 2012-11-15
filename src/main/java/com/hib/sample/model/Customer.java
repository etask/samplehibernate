package com.hib.sample.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EmployeeTable")
public class Customer {
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="eno")
	private int employeeId;
	
	@Column(name="ename")
	private String fName;
	
	@Column(name="esurname")
	private String lName;
	
	@Embedded
	@AttributeOverrides
	({
		@AttributeOverride(name = "city", column = @Column(name = "mycity")),
		@AttributeOverride(name = "postcode", column = @Column(name = "mypostcode"))
	})
	private Address address;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	
}
