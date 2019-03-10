package com.iqsolutions.sms.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vendor_products")
public class VendorProductsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen", sequenceName="vendor_products_seq")
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
