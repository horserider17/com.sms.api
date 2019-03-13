package com.iqsolutions.sms.dtos;

import java.util.Date;
import java.util.List;

public class PostVendorBillDTO {

	private int providerid;
	
	private String vendorname;
	
	private String mobilenumber;
	
	private double advance;
	
	private Date transactiondate;
	
	private double totalamount;

	private List<VendorProductsDTO> products;

	private List<VendorDeductionsDTO> deductions;

	public int getProviderid() {
		return providerid;
	}

	public void setProviderid(int providerid) {
		this.providerid = providerid;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public double getAdvance() {
		return advance;
	}

	public void setAdvance(double advance) {
		this.advance = advance;
	}

	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public List<VendorProductsDTO> getProducts() {
		return products;
	}

	public void setProducts(List<VendorProductsDTO> products) {
		this.products = products;
	}

	public List<VendorDeductionsDTO> getDeductions() {
		return deductions;
	}

	public void setDeductions(List<VendorDeductionsDTO> deductions) {
		this.deductions = deductions;
	}

}
