package com.iqsolutions.sms.dtos;

import java.util.Date;

public class VendorBillsDTO {

	private int vendortransactionid;

	private String vendorname;

	private String mobilenumber;
	
	private double totalamount;
	
	private Date transactiondate;
	
	private boolean isbillgenerated;
	
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

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public int getVendortransactionid() {
		return vendortransactionid;
	}

	public void setVendortransactionid(int vendortransactionid) {
		this.vendortransactionid = vendortransactionid;
	}

	public boolean isIsbillgenerated() {
		return isbillgenerated;
	}

	public void setIsbillgenerated(boolean isbillgenerated) {
		this.isbillgenerated = isbillgenerated;
	}
	
}
