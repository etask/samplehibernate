package com.hib.sample.hr.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Email;

//@Embeddable
public class Contact {
	
	//@Column(nullable=false,name="LAST_NAME")
	private String lastName;
	
	//@Column(name="EMAIL")
	//@Email
	private String email;

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
	
	
	

}
