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
@Table(name="vendor_deductions")
public class VendorDeductionsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen", sequenceName="vendor_deductions_seq")
	private int vendorDeductionId;

	private int vendorTransactionId;
	
	private int deductionTypeId;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "deductionTypeId", referencedColumnName = "deductionTypeId", insertable = false, updatable = false, nullable = false)
	private MasterDeductionTypeEntity masterDeductionTypeEntity;
	
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
