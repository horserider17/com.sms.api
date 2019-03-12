package com.iqsolutions.sms.dtos;

public class MasterDeductionsDTO {

	private String deductiontype;
	
	private double deductionvalue;
	
	private int deductiontypeid;
	
	private int deductionid;
	
	private boolean isactive;

	public String getDeductiontype() {
		return deductiontype;
	}

	public void setDeductiontype(String deductiontype) {
		this.deductiontype = deductiontype;
	}

	public double getDeductionvalue() {
		return deductionvalue;
	}

	public void setDeductionvalue(double deductionvalue) {
		this.deductionvalue = deductionvalue;
	}

	public int getDeductiontypeid() {
		return deductiontypeid;
	}

	public void setDeductiontypeid(int deductiontypeid) {
		this.deductiontypeid = deductiontypeid;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public int getDeductionid() {
		return deductionid;
	}

	public void setDeductionid(int deductionid) {
		this.deductionid = deductionid;
	}
}
