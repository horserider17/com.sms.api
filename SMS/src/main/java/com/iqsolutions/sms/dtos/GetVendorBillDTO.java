package com.iqsolutions.sms.dtos;

import java.util.List;

public class GetVendorBillDTO {

//	private double hamalicost;

	private List<MasterDeductionsDTO> deductions;
	
	private List<VendorBillsDTO> vendorbills;

	public List<MasterDeductionsDTO> getDeductions() {
		return deductions;
	}

	public void setDeductions(List<MasterDeductionsDTO> deductions) {
		this.deductions = deductions;
	}

	public List<VendorBillsDTO> getVendorbills() {
		return vendorbills;
	}

	public void setVendorbills(List<VendorBillsDTO> vendorbills) {
		this.vendorbills = vendorbills;
	}

}
