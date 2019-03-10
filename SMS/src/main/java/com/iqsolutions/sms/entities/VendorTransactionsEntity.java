package com.iqsolutions.sms.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vendor_transactions")
public class VendorTransactionsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen", sequenceName="vendor_transactions_seq")
	private int vendorTransactionId;

	private int vendorId;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorId", referencedColumnName = "vendorId", insertable = false, updatable = false, nullable = false)
	private VendorsEntity vendorsEntity;

	private int providerId;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "providerId", referencedColumnName = "providerId", insertable = false, updatable = false, nullable = false)
	private ProviderEntity providerEntity;
	
	private double advance;
	
	private Date transactionDate;
	
	private boolean isBillGenerated;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorTransactionId", referencedColumnName = "vendorTransactionId", insertable = false, updatable = false, nullable = false)
	private List<VendorProductsEntity> vendorProductsEntities;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorTransactionId", referencedColumnName = "vendorTransactionId", insertable = false, updatable = false, nullable = false)
	private List<VendorDeductionsEntity> vendorDeductionsEntities;
	
	private Date createdAt;

	public int getVendorTransactionId() {
		return vendorTransactionId;
	}

	public void setVendorTransactionId(int vendorTransactionId) {
		this.vendorTransactionId = vendorTransactionId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public VendorsEntity getVendorsEntity() {
		return vendorsEntity;
	}

	public void setVendorsEntity(VendorsEntity vendorsEntity) {
		this.vendorsEntity = vendorsEntity;
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

	public double getAdvance() {
		return advance;
	}

	public void setAdvance(double advance) {
		this.advance = advance;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public boolean isBillGenerated() {
		return isBillGenerated;
	}

	public void setBillGenerated(boolean isBillGenerated) {
		this.isBillGenerated = isBillGenerated;
	}

	public List<VendorProductsEntity> getVendorProductsEntities() {
		return vendorProductsEntities;
	}

	public void setVendorProductsEntities(List<VendorProductsEntity> vendorProductsEntities) {
		this.vendorProductsEntities = vendorProductsEntities;
	}

	public List<VendorDeductionsEntity> getVendorDeductionsEntities() {
		return vendorDeductionsEntities;
	}

	public void setVendorDeductionsEntities(List<VendorDeductionsEntity> vendorDeductionsEntities) {
		this.vendorDeductionsEntities = vendorDeductionsEntities;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
