package com.saviodcosta.xangars.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Random;
import java.util.List;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;

import com.saviodcosta.xangars.model.Policy;
import com.saviodcosta.xangars.model.TempUser;
import com.saviodcosta.xangars.model.WhatsappOptin;
import com.saviodcosta.xangars.model.AuthRequest;
import com.saviodcosta.xangars.model.JWTTokenResponse;
import com.saviodcosta.xangars.model.MessageResponse;
import com.saviodcosta.xangars.model.STATUS_CODE_CONSTANTS;
import com.saviodcosta.xangars.repository.PolicyRepository;
import com.saviodcosta.xangars.repository.TempUserRepository;
import com.saviodcosta.xangars.repository.WhatsappOptinRepository;

@RestController
@RequestMapping("/api/v1/")
public class JWTController {
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private TempUserRepository tempUserRepository;
	
	@Autowired
	private WhatsappOptinRepository whatsappOptinRepository;

	//authenticate
	@PostMapping(
			value = "authenticate",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<JWTTokenResponse> authenticate(@RequestBody AuthRequest request) {
		
		TempUser reqTempUser = tempUserRepository.findByOtp(request.getOTP());
		if (reqTempUser.getMobileNumber() != request.getMobile_number()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		List<Policy> policies = policyRepository.findByMobileNumber(request.mobileNumber);
		if (policies == null || policies.size() == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		String OTP = String.format("%06d", new Random().nextInt(999999));
		TempUser tempUser = new TempUser(request.mobileNumber, OTP);
		tempUserRepository.createTempUser(tempUser);
		return ResponseEntity.created(URI.create(String.format(""))).body(new JWTTokenResponse(STATUS_CODE_CONSTANTS.GET, tempUser.getToken(), tempUser.getRefresh()));
	}
	
	
	//optin
	@PostMapping(
			value = "optin",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<MessageResponse> optin(@RequestBody String request) {
		
		List<WhatsappOptin> whatsappOptin = whatsappOptinRepository.getOptinForMobileNumber(request);
		
		if (whatsappOptin == null || whatsappOptin.size() == 0) {
			List<Policy> policies = policyRepository.findByMobileNumber(request);
			if (policies == null || policies.size() == 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			} else {
				String OTP = String.format("%06d", new Random().nextInt(999999));
				tempUserRepository.createTempUser(new TempUser(request, OTP));
				return ResponseEntity.created(URI.create(String.format(""))).body(new MessageResponse(STATUS_CODE_CONSTANTS.OTP_SENT, "Optin OTP Sent on the Mobile Number"));
			}
		} else {
			return ResponseEntity.created(URI.create(String.format(""))).body(new MessageResponse(STATUS_CODE_CONSTANTS.OLD_USER, "Thank You for Optin Request Completed"));
		}
	}
	
	
	//optin verification
	@PostMapping(
			value = "verify_optin",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<MessageResponse> optinVerification(@RequestBody AuthRequest request) {
		TempUser tempUser = tempUserRepository.findByMobileNumber(request.getMobile_number());
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		if (tempUser.getOtp() != request.getOTP() || tempUser.getExprieTime().before(now) ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			List<Policy> policies = policyRepository.findByMobileNumber(request.getMobile_number());
			for (Policy c : policies) {
				WhatsappOptin whatsappOptin = new WhatsappOptin(request.getMobile_number(), c, new Date(now.getTime()));
				whatsappOptinRepository.createWhatsappOptin(whatsappOptin);
			}
			return ResponseEntity.created(URI.create(String.format(""))).body(new MessageResponse(STATUS_CODE_CONSTANTS.NEW_USER, "Thank You for Optin Request Completed"));
		}
	}
	
}
