package com.saviodcosta.xangars.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.saviodcosta.xangars.model.Policy;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "whatsapp_optin")
public class WhatsappOptin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "optin_id")
	private long optinId;
	
	@Column(name = "mobileNumber")
	private String mobileNumber;
	
	@OneToOne
	@JoinColumn(name = "policyNumber", unique=true)
	private Policy policy;
	
	@Column(name = "optin_date")
	private Date optInDate;

	public WhatsappOptin() {
		super();
	}

	public WhatsappOptin(String mobileNumber, Policy policy, Date optInDate) {
		super();
		this.mobileNumber = mobileNumber;
		this.policy = policy;
		this.optInDate = optInDate;
	}

	public long getOptinID() {
		return optinId;
	}

	public void setOptinID(long optInID) {
		this.optinId = optInID;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Policy getPolicyNumber() {
		return policy;
	}

	public void setPolicyNumber(Policy policy) {
		this.policy = policy;
	}

	public Date getOptInDate() {
		return optInDate;
	}

	public void setOptInDate(Date optInDate) {
		this.optInDate = optInDate;
	}
	
	@Override
	public String toString() {
		return "Policy [optInID=" + optinId + ", mobileNumber=" + mobileNumber + ", policyNumber=" + policy.getPolicyNumber()
				+ ", optInDate=" + optInDate + "]";
	}
}
