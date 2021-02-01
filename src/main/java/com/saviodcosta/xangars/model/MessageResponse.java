package com.saviodcosta.xangars.model;

public class MessageResponse {
	
	int status;
	
	String message;

	
	public MessageResponse() {
		super();
	}

	public MessageResponse(STATUS_CODE_CONSTANTS status, String message) {
		super();
		this.status = status.label;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

