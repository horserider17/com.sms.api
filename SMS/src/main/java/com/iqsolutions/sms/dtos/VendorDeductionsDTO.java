package com.iqsolutions.sms.dtos;

import java.util.Date;

public class VendorDeductionsDTO {

	private int vendorDeductionId;

	private int vendorTransactionId;
	
	private int deductionTypeId;
	
	private MasterDeductionTypeDTO masterDeductionTypeEntity;
	
	private double deductionValue;
	
	private Date createdAt;

	public int getVendorDeductionId() {
		return vendorDeductionId;
	}

	public void setVendorDeductionId(int vendorDeductionId) {
		this.vendorDeductionId = vendorDeductionId;
	}

	public int getVendorTransactionId() {
		return vendorTransactionId;
	}

	public void setVendorTransactionId(int vendorTransactionId) {
		this.vendorTransactionId = vendorTransactionId;
	}

	public int getDeductionTypeId() {
		return deductionTypeId;
	}

	public void setDeductionTypeId(int deductionTypeId) {
		this.deductionTypeId = deductionTypeId;
	}

	public MasterDeductionTypeDTO getMasterDeductionTypeEntity() {
		return masterDeductionTypeEntity;
	}

	public void setMasterDeductionTypeEntity(MasterDeductionTypeDTO masterDeductionTypeEntity) {
		this.masterDeductionTypeEntity = masterDeductionTypeEntity;
	}

	public double getDeductionValue() {
		return deductionValue;
	}

	public void setDeductionValue(double deductionValue) {
		this.deductionValue = deductionValue;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
