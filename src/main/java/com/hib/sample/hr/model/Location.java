package com.hib.sample.hr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class Location {
	
	@Id
	@Column(name="LOCATION_ID")
	private int locationId;
	
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(nullable=false,name="CITY")
	private String city;
	
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	
	@JoinColumn(name="COUNTRY_ID")
	@ManyToOne
	private Country country;
	
	@OneToMany(mappedBy="location")
	private List<Department> departments;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	
	

}
