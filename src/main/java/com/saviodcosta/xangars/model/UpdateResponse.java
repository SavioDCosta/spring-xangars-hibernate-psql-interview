package com.saviodcosta.xangars.model;

public class UpdateResponse {
	
	int status;
	
	String data;
	
	String message;

	
	public UpdateResponse(STATUS_CODE_CONSTANTS status, String data, String message) {
		super();
		this.status = status.label;
		this.data = data;
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
