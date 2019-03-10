package com.iqsolutions.sms.dtos;

import java.util.Date;

public class MasterDeductionTypeDTO {

	private int deductionTypeId;

	private String deductionType;

	private boolean isPercentage;

	private int providerId;
	
	private ProviderDTO providerEntity;
	
	private Date createdAt;
	
	public int getDeductionTypeId() {
		return deductionTypeId;
	}
	public void setDeductionTypeId(int deductionTypeId) {
		this.deductionTypeId = deductionTypeId;
	}
	public String getDeductionType() {
		return deductionType;
	}
	public void setDeductionType(String deductionType) {
		this.deductionType = deductionType;
	}
	public boolean isPercentage() {
		return isPercentage;
	}
	public void setPercentage(boolean isPercentage) {
		this.isPercentage = isPercentage;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
