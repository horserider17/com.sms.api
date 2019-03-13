package com.iqsolutions.sms.dtos;

public class LoginResponseDTO {

	private int providerId;
	
	private String mobileNumber;
	
	private String firstName;	

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
