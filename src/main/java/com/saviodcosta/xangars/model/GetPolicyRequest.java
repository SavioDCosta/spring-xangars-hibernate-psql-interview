package com.saviodcosta.xangars.model;

public class GetPolicyRequest {
	
	private long policyNumber;
	
	private String token;

	
	public GetPolicyRequest() {
		super();
	}

	
	public GetPolicyRequest(long policyNumber, String token) {
		super();
		this.policyNumber = policyNumber;
		this.token = token;
	}


	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
