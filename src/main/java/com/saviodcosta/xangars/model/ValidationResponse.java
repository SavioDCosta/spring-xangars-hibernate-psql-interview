package com.saviodcosta.xangars.model;

public class ValidationResponse {

	int status;
	
	String data;

	public ValidationResponse(STATUS_CODE_CONSTANTS status, String data) {
		super();
		this.status = status.label;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
