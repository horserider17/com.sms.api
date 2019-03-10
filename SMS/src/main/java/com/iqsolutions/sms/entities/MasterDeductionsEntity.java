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
@Table(name="master_deductions")
public class MasterDeductionsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen", sequenceName="master_deductions_seq")
	private int deductionId;

	private int deductionTypeId;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "deductionTypeId", referencedColumnName = "deductionTypeId", insertable = false, updatable = false, nullable = false)
	private MasterDeductionTypeEntity masterDeductionTypeEntity;

	private double deductionValue;

	private int providerId;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "providerId", referencedColumnName = "providerId", insertable = false, updatable = false, nullable = false)
	private ProviderEntity providerEntity;
	
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

	public MasterDeductionTypeEntity getMasterDeductionTypeEntity() {
		return masterDeductionTypeEntity;
	}

	public void setMasterDeductionTypeEntity(MasterDeductionTypeEntity masterDeductionTypeEntity) {
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

	public ProviderEntity getProviderEntity() {
		return providerEntity;
	}

	public void setProviderEntity(ProviderEntity providerEntity) {
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
