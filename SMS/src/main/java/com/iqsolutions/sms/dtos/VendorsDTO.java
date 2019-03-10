package com.iqsolutions.sms.dtos;

import java.util.Date;

public class VendorsDTO {

	private int vendorId;

	private String vendorName;

	private String mobileNumber;

	private String address;

	private int providerId;
	
	private ProviderDTO providerEntity;
	
	private Date createdAt;
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
