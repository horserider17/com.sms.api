package com.iqsolutions.sms.dtos;

import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class VendorTransactionsDTO {

	private int vendorTransactionId;

	private int vendorId;
	
	private VendorsDTO vendorsEntity;

	private int providerId;
	
	private ProviderDTO providerEntity;
	
	private double advance;
	
	private Date transactionDate;
	
	private boolean isBillGenerated;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorTransactionId", referencedColumnName = "vendorTransactionId", insertable = false, updatable = false, nullable = false)
	private List<VendorProductsDTO> vendorProductsEntities;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorTransactionId", referencedColumnName = "vendorTransactionId", insertable = false, updatable = false, nullable = false)
	private List<VendorDeductionsDTO> vendorDeductionsEntities;
	
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

	public VendorsDTO getVendorsEntity() {
		return vendorsEntity;
	}

	public void setVendorsEntity(VendorsDTO vendorsEntity) {
		this.vendorsEntity = vendorsEntity;
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

	public List<VendorProductsDTO> getVendorProductsEntities() {
		return vendorProductsEntities;
	}

	public void setVendorProductsEntities(List<VendorProductsDTO> vendorProductsEntities) {
		this.vendorProductsEntities = vendorProductsEntities;
	}

	public List<VendorDeductionsDTO> getVendorDeductionsEntities() {
		return vendorDeductionsEntities;
	}

	public void setVendorDeductionsEntities(List<VendorDeductionsDTO> vendorDeductionsEntities) {
		this.vendorDeductionsEntities = vendorDeductionsEntities;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
