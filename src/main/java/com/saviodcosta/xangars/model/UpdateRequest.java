package com.saviodcosta.xangars.model;

public class UpdateRequest {
	
	String field;
	
	long id;
	
	String token;

	public UpdateRequest(String field, long id, String token) {
		super();
		this.field = field;
		this.id = id;
		this.token = token;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
