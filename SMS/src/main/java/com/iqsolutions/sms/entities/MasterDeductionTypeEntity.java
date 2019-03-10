package com.iqsolutions.sms.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="master_deduction_type")
public class MasterDeductionTypeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen", sequenceName="master_deduction_type_seq")
	private int deductionTypeId;

	private String deductionType;

	private boolean isPercentage;

	private int providerId;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "providerId", referencedColumnName = "providerId", insertable = false, updatable = false, nullable = false)
	private ProviderEntity providerEntity;
	
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
	public ProviderEntity getProviderEntity() {
		return providerEntity;
	}
	public void setProviderEntity(ProviderEntity providerEntity) {
		this.providerEntity = providerEntity;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
