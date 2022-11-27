package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ApproveClaimDto;
import com.lti.dto.ClaimDto;
import com.lti.dto.GetAllClaims;
import com.lti.entity.Claim;
import com.lti.entity.Customer;
import com.lti.entity.Policy;
import com.lti.exception.InsuranceServiceException;
import com.lti.service.ClaimInsuranceService;
import com.lti.status.Status;
import com.lti.status.Status.StatusType;

@RestController
@CrossOrigin
public class ClaimInsuranceController {
	@Autowired
	private ClaimInsuranceService service;

	@PostMapping(path = "/addClaimInsurance", consumes = "application/json", produces = "application/json")
	public Status submitClaimDetails(@RequestBody ClaimDto claimDto) {
		try {

			Claim claim = new Claim();
			claim.setDate(claimDto.getDate());
			claim.setStatus(claimDto.getStatus());
			claim.setAmount(claimDto.getAmount());
			claim.setReason(claimDto.getReason());
			claim.setContactNo(claimDto.getContactNo());

			Customer customer = service.findByCustomerId(claimDto.getCustomerId());
			claim.setCustomer(customer);

			Policy policy = service.findByPolicyId(claimDto.getPolicyId());
			claim.setPolicy(policy);

			service.saveAndUpdateOfClaimInsuranceDetails(claim);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Claim Details Are Submitted Successfully.");
			return status;
		} catch (InsuranceServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping(path = "/updateClaimStatus", consumes = "application/json", produces = "application/json")
	public Status updateClaimStatus(@RequestBody ApproveClaimDto approveClaimDto) {
		try {

			// Check if session id is of ADMIN role from User table -not added
			// is role is not admin then throw InsuranceServiceException

			Claim claim = service.getClaimDataById(approveClaimDto.getClaimId());

			claim.setStatus(approveClaimDto.getStatus());

			service.saveAndUpdateOfClaimInsuranceDetails(claim);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Claim status is updated Successfully.");
			return status;

		} catch (Exception e) {
			Status status = new Status();
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILURE);

			return status;
		}
	}
	
	@PostMapping(path = "/getAllClaims", consumes = "application/json", produces = "application/json")
	public Status getClaims(@RequestBody GetAllClaims getAllClaims) {
		try {

			// Check if session id is of ADMIN role from User table -not added
			// is role is not admin then throw InsuranceServiceException

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Claim status is updated Successfully.");
			return status;

		} catch (Exception e) {
			Status status = new Status();
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILURE);

			return status;
		}
	}
}
