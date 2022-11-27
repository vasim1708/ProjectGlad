package com.lti.repository;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.entity.InsurancePlan;
import com.lti.entity.Vehicle;

public interface BuyInsuranceRepository {
	
	boolean isSameVehicleIsInsuredAlready(String registrationNo);
	
	void submissionOfBuyInsuranceData(Vehicle vehicle);
	
	Customer findById(int id);

	List<InsurancePlan> getAllInsuranceData();
}