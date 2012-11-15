package com.hib.sample.model;

import javax.persistence.Embeddable;

@Embeddable
public class ProductDetails {

	private String productName;
	private String productDescription;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	
}
