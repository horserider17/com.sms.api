package com.iqsolutions.sms.dtos;

public class VendorDeductionsDTO {

//	private int vendorDeductionId;
//
//	private int vendorTransactionId;

	private int deductiontypeid;
	
//	private MasterDeductionTypeDTO masterDeductionTypeEntity;
	
	private double deductionvalue;
	
//	private Date createdAt;

	public int getDeductiontypeid() {
		return deductiontypeid;
	}

	public void setDeductiontypeid(int deductiontypeid) {
		this.deductiontypeid = deductiontypeid;
	}

	public double getDeductionvalue() {
		return deductionvalue;
	}

	public void setDeductionvalue(double deductionvalue) {
		this.deductionvalue = deductionvalue;
	}
	
}
