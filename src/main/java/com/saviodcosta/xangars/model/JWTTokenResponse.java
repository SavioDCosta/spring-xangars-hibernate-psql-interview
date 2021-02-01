package com.saviodcosta.xangars.model;

import com.saviodcosta.xangars.model.STATUS_CODE_CONSTANTS;

public class JWTTokenResponse {
	
	public int status;
	
	public String token;
	
	public String refresh;

	public JWTTokenResponse() {
		super();
	}

	public JWTTokenResponse(STATUS_CODE_CONSTANTS status, String token, String refresh) {
		super();
		this.status = status.label;
		this.token = token;
		this.refresh = refresh;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(STATUS_CODE_CONSTANTS status) {
		this.status = status.label;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRefresh() {
		return refresh;
	}

	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}
	
	
}
