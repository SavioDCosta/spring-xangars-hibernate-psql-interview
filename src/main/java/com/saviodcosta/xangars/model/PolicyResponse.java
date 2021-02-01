package com.saviodcosta.xangars.model;

public class PolicyResponse {
	
	int status;
	
	Policy policy;
	
	public PolicyResponse(STATUS_CODE_CONSTANTS status, Policy policy) {
		super();
		this.status = status.label;
		this.policy = policy;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	
}
