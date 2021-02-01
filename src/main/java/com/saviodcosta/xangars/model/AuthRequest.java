package com.saviodcosta.xangars.model;


public class AuthRequest {
	
	public String mobileNumber;
	
	public String OTP;
	
	public AuthRequest() {
		super();
	}

	public AuthRequest(String mobile_number, String oTP) {
		super();
		this.mobileNumber = mobile_number;
		OTP = oTP;
	}

	public String getMobile_number() {
		return mobileNumber;
	}

	public void setMobile_number(String mobile_number) {
		this.mobileNumber = mobile_number;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String OTP) {
		this.OTP = OTP;
	}

}
