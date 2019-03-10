package com.iqsolutions.sms.dtos;

import java.util.Date;

public class VendorProductsDTO {

	private int vendorProductId;

	private int vendorTransactionId;
	
	private double productQty;
	
	private double productPrice;
	
	private Date createdAt;

	public int getVendorProductId() {
		return vendorProductId;
	}

	public void setVendorProductId(int vendorProductId) {
		this.vendorProductId = vendorProductId;
	}

	public int getVendorTransactionId() {
		return vendorTransactionId;
	}

	public void setVendorTransactionId(int vendorTransactionId) {
		this.vendorTransactionId = vendorTransactionId;
	}

	public double getProductQty() {
		return productQty;
	}

	public void setProductQty(double productQty) {
		this.productQty = productQty;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
