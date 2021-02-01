package com.saviodcosta.xangars.model;

import java.util.UUID;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "temp_user")
public class TempUser {
	
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "mobileNumber")
	private String mobileNumber;
	
	@Column(name = "otp")
	private String otp;
	
	@Column(name = "created_time")
	private Timestamp createdTime;
	
	@Column(name = "expire_time")
	private Timestamp expireTime;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "refresh")
	private String refresh;

	public TempUser() {
		super();
	}

	public TempUser(String mobileNumber, String otp) {
		super();
		this.mobileNumber = mobileNumber;
		this.otp = otp;
		this.createdTime = new Timestamp(System.currentTimeMillis());
		this.expireTime = new Timestamp(System.currentTimeMillis() + 300000);	//5mins
		this.token = UUID.randomUUID().toString().replace("-", "");
		this.refresh = UUID.randomUUID().toString().replace("-", "");
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getExprieTime() {
		return expireTime;
	}

	public void setExprieTime(Timestamp exprieTime) {
		this.expireTime = exprieTime;
	}
	
	@Override
	public String toString() {
		return "OTPManagement [mobileNumber=" + mobileNumber + ", otp=" + otp + ", expireTime=" + expireTime + ", createdTime="
				+ createdTime + "]";
	}

}
