package com.iqsolutions.sms.dtos;

public class VendorProductsDTO {

//	private int vendorProductId;
//
//	private int vendorTransactionId;
	
	private double quantity;
	
	private double price;
	
//	private Date createdAt;

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
