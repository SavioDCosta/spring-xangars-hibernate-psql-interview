package com.saviodcosta.xangars.model;

import java.util.Date;

public class ValidationRequest {
	String field;
	
	String dob;
	
	String token;

	public ValidationRequest(String field, String dob, String token) {
		super();
		this.field = field;
		this.dob = dob;
		this.token = token;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
