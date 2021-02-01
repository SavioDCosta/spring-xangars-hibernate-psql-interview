package com.saviodcosta.xangars.model;

public enum STATUS_CODE_CONSTANTS {
	OLD_USER(1001),
	NEW_USER(1002),
	OTP_SENT(1003),
	REQUEST(1004),
	VALIDATION(1005),
	GET(1006);
	
	public final int label;
	
	private STATUS_CODE_CONSTANTS(int label) {
		this.label = label;
	}
	
	@Override
	  public String toString() {
	    switch(this) {
	      case OLD_USER: return String.valueOf(OLD_USER.label);
	      case NEW_USER: return String.valueOf(NEW_USER.label);
	      case OTP_SENT: return String.valueOf(OTP_SENT.label);
	      case REQUEST: return String.valueOf(REQUEST.label);
	      case VALIDATION: return String.valueOf(VALIDATION.label);
	      case GET: return String.valueOf(GET.label);
	      default: throw new IllegalArgumentException();
	    }
	  }
	
}
