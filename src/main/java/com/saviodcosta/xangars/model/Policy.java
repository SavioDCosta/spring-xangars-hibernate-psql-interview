package com.saviodcosta.xangars.model;

import java.util.Date;
import java.sql.Timestamp;

import com.saviodcosta.xangars.model.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "policy")
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "policy_number")
	private long policyNumber;
	
	@Column(name = "customer_id")
	private long customerID;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "insured_name")
	private String insuredName;
	
	@Column(name = "customer_dob")
	private Date customerDob;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobileNumber")
	private String mobileNumber;
	
	private enum PremiumMode {
	    Monthly, Yearly, HalfYearly;
	}
	
	@Column(name = "premium_mode")
	@Enumerated(EnumType.ORDINAL)
	private PremiumMode premiumMode;
	
	private enum PolicyStatus {
	    Active, Inactive;
	}
	
	@Column(name = "policy_status")
	@Enumerated(EnumType.ORDINAL)
	private PolicyStatus policyStatus;

	@Column(name = "pan_number")
	private String panNumber;
	
	@Column(name = "policy_issuance_date")
	private Date policyIssuanceDate; 
	
	@Column(name = "contact_last_updated")
	private Timestamp contactLastUpdated;
	
	@Column(name = "email_last_updated")
	private Timestamp emailLastUpdated;
	
	@Column(name = "bank_account_number")
	private String bankAccountNumber;
	
	private enum WhatsappOptInStatus {
	    Yes, No;
	}
	
	@Column(name = "whatsapp_optin_status")
	@Enumerated(EnumType.ORDINAL)
	private WhatsappOptInStatus whatsappOptInStatus;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "reinvest_applicable")
	private boolean reinvestApplicable;
	
	@Column(name = "outstanding_payout")
	private double outstandingPayout;
	
	@Column(name = "unclaimed_amount")
	private double unclaimedAmount;
	
	@Column(name = "NEFT_registered")
	private boolean NEFTRegistered;
	
	private enum LastPremiumPaid {
	    Yes, No;
	}
	
	@Column(name = "last_premium_paid")
	@Enumerated(EnumType.ORDINAL)
	private LastPremiumPaid lastPremiumPaid;

	public Policy() {
		super();
	}

	public Policy(long policyNumber, long customerID, String customerName, String insuredName, Date customerDob, String emailID, String mobileNumber,
			PremiumMode premiumMode, PolicyStatus policyStatus, String panNumber, Date policyIssuanceDate,
			Timestamp contactLastUpdated, Timestamp emailLastUpdated, String bankAccountNumber, WhatsappOptInStatus whatsappOptInStatus,
			Product product, boolean reinvestApplicable, double outstandingPayout, double unclaimedAmount, boolean nEFTRegistered, LastPremiumPaid lastPremiumPaid) {
		super();
		this.policyNumber = policyNumber;
		this.customerID = customerID;
		this.customerName = customerName;
		this.insuredName = insuredName;
		this.customerDob = customerDob;
		this.email = emailID;
		this.mobileNumber = mobileNumber;
		this.premiumMode = premiumMode;
		this.policyStatus = policyStatus;
		this.panNumber = panNumber;
		this.policyIssuanceDate = policyIssuanceDate;
		this.contactLastUpdated = contactLastUpdated;
		this.emailLastUpdated = emailLastUpdated;
		this.bankAccountNumber = bankAccountNumber;
		this.whatsappOptInStatus = whatsappOptInStatus;
		this.product = product;
		this.reinvestApplicable = reinvestApplicable;
		this.outstandingPayout = outstandingPayout;
		this.unclaimedAmount = unclaimedAmount;
		this.NEFTRegistered = nEFTRegistered;
		this.lastPremiumPaid = lastPremiumPaid;
	}
	
	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailID) {
		this.email = emailID;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public PremiumMode getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(PremiumMode premiumMode) {
		this.premiumMode = premiumMode;
	}

	public PolicyStatus getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(PolicyStatus policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Date getPolicyIssuanceDate() {
		return policyIssuanceDate;
	}

	public void setPolicyIssuanceDate(Date policyIssuanceDate) {
		this.policyIssuanceDate = policyIssuanceDate;
	}

	public Timestamp getContactLastUpdated() {
		return contactLastUpdated;
	}

	public void setContactLastUpdated(Timestamp contactLastUpdated) {
		this.contactLastUpdated = contactLastUpdated;
	}

	public Timestamp getEmailLastUpdated() {
		return emailLastUpdated;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public void setEmailLastUpdated(Timestamp emailLastUpdated) {
		this.emailLastUpdated = emailLastUpdated;
	}

	public WhatsappOptInStatus getWhatsappOptInStatus() {
		return whatsappOptInStatus;
	}

	public void setWhatsappOptInStatus(WhatsappOptInStatus whatsappOptInStatus) {
		this.whatsappOptInStatus = whatsappOptInStatus;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isReinvestApplicable() {
		return reinvestApplicable;
	}

	public void setReinvestApplicable(boolean reinvestApplicable) {
		this.reinvestApplicable = reinvestApplicable;
	}

	public double getOutstandingPayout() {
		return outstandingPayout;
	}

	public void setOutstandingPayout(double outstandingPayout) {
		this.outstandingPayout = outstandingPayout;
	}

	public double getUnclaimedAmount() {
		return unclaimedAmount;
	}

	public void setUnclaimedAmount(double unclaimedAmount) {
		this.unclaimedAmount = unclaimedAmount;
	}

	public boolean isNEFTRegistered() {
		return NEFTRegistered;
	}

	public void setNEFTRegistered(boolean nEFTRegistered) {
		NEFTRegistered = nEFTRegistered;
	}

	public LastPremiumPaid getLastPremiumPaid() {
		return lastPremiumPaid;
	}

	public void setLastPremiumPaid(LastPremiumPaid lastPremiumPaid) {
		this.lastPremiumPaid = lastPremiumPaid;
	}
	
	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", customerID=" + customerID + ", customerName=" + customerName
				+ ", insuredName=" + insuredName + ", dob=" + customerDob + ", emailAddress=" + email + ", mobileNumber="
				+ mobileNumber + ", premiumMode=" + premiumMode + ", policyStatus=" + policyStatus + ", customerPANNO="
				+ panNumber + ", policyIssuanceDate=" + policyIssuanceDate + ", contactNumberLastUpdated="
				+ contactLastUpdated + ", emailAddressLastUpdated=" + emailLastUpdated
				+ ", bankAccountNumber=" + bankAccountNumber + ", whatsappOptInStatus=" + whatsappOptInStatus
				+ ", productName=" + product.getName() + ", productID=" + product.getId() + ", reinvestApplicable="
				+ reinvestApplicable + ", outstandingPayout=" + outstandingPayout + ", unclaimedAmount="
				+ unclaimedAmount + ", neftRegistered=" + NEFTRegistered + ", lastPremiumPaid=" + lastPremiumPaid + "]";
	}
}
