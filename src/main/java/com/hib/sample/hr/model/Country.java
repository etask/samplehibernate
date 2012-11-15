package com.hib.sample.hr.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Country {

	@Id
	@Column(name="COUNTRY_ID",columnDefinition = "char")
	private String countryId;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@JoinColumn(name="REGION_ID")
	@ManyToOne	
	private Region region;
	
	@OneToMany(mappedBy="country")
	private List<Location> locations = new ArrayList<Location>();

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	
	
	
}
