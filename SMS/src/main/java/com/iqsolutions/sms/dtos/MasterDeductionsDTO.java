package com.iqsolutions.sms.dtos;

import java.util.Date;

public class MasterDeductionsDTO {

	private int deductionId;

	private int deductionTypeId;
	
	private MasterDeductionTypeDTO masterDeductionTypeEntity;

	private double deductionValue;

	private int providerId;
	
	private ProviderDTO providerEntity;
	
	private boolean isActive;
	
	private Date createdAt;

	public int getDeductionId() {
		return deductionId;
	}

	public void setDeductionId(int deductionId) {
		this.deductionId = deductionId;
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

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public ProviderDTO getProviderEntity() {
		return providerEntity;
	}

	public void setProviderEntity(ProviderDTO providerEntity) {
		this.providerEntity = providerEntity;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
