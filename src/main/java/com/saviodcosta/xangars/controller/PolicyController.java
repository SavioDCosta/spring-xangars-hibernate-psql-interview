package com.saviodcosta.xangars.controller;

import java.net.URI;
import java.util.List;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saviodcosta.xangars.model.GetPolicyRequest;
import com.saviodcosta.xangars.model.PolicyResponse;
import com.saviodcosta.xangars.model.ValidationRequest;
import com.saviodcosta.xangars.model.ValidationResponse;
import com.saviodcosta.xangars.model.UpdateRequest;
import com.saviodcosta.xangars.model.UpdateResponse;
import com.saviodcosta.xangars.model.Policy;
import com.saviodcosta.xangars.model.STATUS_CODE_CONSTANTS;
import com.saviodcosta.xangars.model.TempUser;
import com.saviodcosta.xangars.repository.PolicyRepository;
import com.saviodcosta.xangars.repository.TempUserRepository;

@RestController
@RequestMapping("/api/v1/")
public class PolicyController {

	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private TempUserRepository tempUserRepository;
	
	//get policy
	@GetMapping(
			value = "policy",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<PolicyResponse> getPolicy(@RequestBody GetPolicyRequest request) {
		
		TempUser tempUser = tempUserRepository.findByToken(request.getToken());
		
		Policy policy = policyRepository.findById(request.getPolicyNumber());
		if (policy == null || policy.getMobileNumber() != tempUser.getToken()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return ResponseEntity.created(URI.create(String.format(""))).body(new PolicyResponse(STATUS_CODE_CONSTANTS.GET, policy));
	}
	
	//email validation
	@PostMapping(
			value = "/validate/email",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ValidationResponse> validateEmail(@RequestBody ValidationRequest request) {
		TempUser tempUser = tempUserRepository.findByToken(request.getToken());
		
		Policy policy = policyRepository.findByEmail(request.getField());
		if (policy == null || policy.getMobileNumber() != tempUser.getToken()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		if (policy == null || new SimpleDateFormat("dd-MM-yyyy").format(policy.getCustomerDob()) != request.getDob()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.created(URI.create(String.format(""))).body(new ValidationResponse(STATUS_CODE_CONSTANTS.VALIDATION, request.getField()));
	}
	
	//phone validation
	@PostMapping(
			value = "/validate/mobile",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ValidationResponse> validateMobile(@RequestBody ValidationRequest request) {
		TempUser tempUser = tempUserRepository.findByToken(request.getToken());
		
		Policy policy = policyRepository.findByMobileNumber(request.getField()).get(0);
		if (policy == null || policy.getMobileNumber() != tempUser.getToken()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		if (policy == null || new SimpleDateFormat("dd-MM-yyyy").format(policy.getCustomerDob()) != request.getDob()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.created(URI.create(String.format(""))).body(new ValidationResponse(STATUS_CODE_CONSTANTS.VALIDATION, request.getField()));
	}
	
	
	// update email
	@PostMapping(
			value = "/update/email",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UpdateResponse> updateEmail(@RequestBody UpdateRequest request) {
		TempUser tempUser = tempUserRepository.findByToken(request.getToken());
		
		Policy policy = policyRepository.findById(request.getId());
		if (policy == null || policy.getMobileNumber() != tempUser.getToken()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		// Actual updation
		// policy.setEmail(request.getField());
		// policyRepository.update(policy);
		String serviceRequest = "SR" + String.format("%06d", new Random().nextInt(999999));
		return ResponseEntity.created(URI.create(String.format(""))).body(new UpdateResponse(STATUS_CODE_CONSTANTS.REQUEST, serviceRequest, "Service Request for Emai Address Updation Generated"));
	}
	
	// update mobile
	@PostMapping(
			value = "/update/mobile",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UpdateResponse> updateMobile(@RequestBody UpdateRequest request) {
		TempUser tempUser = tempUserRepository.findByToken(request.getToken());
		
		Policy policy = policyRepository.findById(request.getId());
		if (policy == null || policy.getMobileNumber() != tempUser.getToken()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		// Actual updation
		// policy.setMobileNumber(request.getField());
		// policyRepository.update(policy);
		String serviceRequest = "SR" + String.format("%06d", new Random().nextInt(999999));
		return ResponseEntity.created(URI.create(String.format(""))).body(new UpdateResponse(STATUS_CODE_CONSTANTS.REQUEST, serviceRequest, "Service Request for Mobile Number Updation Generated"));
	}
	
	// update mobile
	@PostMapping(
			value = "/update/pancard",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UpdateResponse> updatePanCard(@RequestBody UpdateRequest request) {
		TempUser tempUser = tempUserRepository.findByToken(request.getToken());
		
		Policy policy = policyRepository.findById(request.getId());
		if (policy == null || policy.getMobileNumber() != tempUser.getToken()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		// Actual updation
		// policy.setPanNumber(request.getField());
		// policyRepository.update(policy);
		String serviceRequest = "SR" + String.format("%06d", new Random().nextInt(999999));
		return ResponseEntity.created(URI.create(String.format(""))).body(new UpdateResponse(STATUS_CODE_CONSTANTS.REQUEST, serviceRequest, "Service Request for PAN Card Updation Generated"));
	}
		
}
