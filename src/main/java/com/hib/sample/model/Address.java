package com.hib.sample.model;

import javax.persistence.Embeddable;


@Embeddable
public class Address {
	
	private String city;
	private String postCode;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	

}
