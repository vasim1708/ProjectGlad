package com.lti;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.*;
import com.lti.repository.RenewRepository;

public class RenewTest {
	
	@Autowired
	private RenewRepository renewRepo;
	
	@Test
	public void addValue() {
		/*Vehicle vehicle = new Vehicle();
		vehicle.setId(2);
		vehicle.setType("4-Wheeler");
		vehicle.setModel("Santro GLS");
		vehicle.setManufacturer("Hyundai");
		vehicle.setDrivingLicense("UK07111");
		vehicle.setPurchaseDate(LocalDate.of(2008, 4, 21));
		vehicle.setRegistrationNo("UK07222");
		vehicle.setEngineNo("ENG333");
		vehicle.setChassisNo("CH444");
		vehicle.setEngineType("Petrol");
		//vehicle.setCustomer(2);
		vehicle.setLastRenewDate(LocalDate.of(2019, 8, 31));
		renewRepo.save(vehicle);
	
		Address address = new Address();
		address.setId(2);
		address.setCity("Hyderabad");
		address.setPincode(500068);
		address.setLandMark("GSI Post");
		renewRepo.save(address);
		
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Stuti Tripathi");
		customer.setEmailId("stuti@gmail");
		customer.setDateOfBirth(LocalDate.of(1998, 9, 12));
		customer.setContactNo(1234567899);
		//customer.setAddress(2);
		customer.setPassword("abc111");
		renewRepo.save(customer);
		
		InsurancePlan insurancePlan = new InsurancePlan();
		insurancePlan.setId(2);
		insurancePlan.setName("Comprehensive");
		insurancePlan.setType("4-Wheeler");
		insurancePlan.setDuration(1);
		insurancePlan.setAmount(3000);
		insurancePlan.setCommission(500);
		renewRepo.save(insurancePlan);
		
		Payment payment = new Payment();
		payment.setId(2);
		//payment.setCustomer(2);
		payment.setAmount(3500);
		payment.setMode("cash");
		payment.setDate(LocalDate.of(2019, 8, 31));
		renewRepo.save(payment);
		
		Policy policy = new Policy();
		policy.setId(2);
		policy.setIssueDate(LocalDate.of(2019, 8, 31));
		policy.setExpiryDate(LocalDate.of(2020, 8, 31));
		policy.setDuration(1);
		policy.setPolicyAmount(3000.0);
		policy.setPlan_amount(500.0);
		policy.setStatus("Valid");
		//policy.setCustomer(customer);
		//policy.setInsurancePlan(2);
		renewRepo.save(policy);
		
		Claim claim = new Claim();
		claim.setId(2);
		claim.setDate(LocalDate.of(2020, 6, 12));
		claim.setStatus("Claimed");
		claim.setAmount(3500);
		//claim.setPolicy(2);
		claim.setReason("Natural");
		claim.setContactNo(1234567899);
		//claim.setCustomer(2);
		renewRepo.save(claim);
		
		Users users = new Users();
		users.setId(2);
		users.setEmailId("stuti@gmail");
		users.setPassword("abc111");
		users.setLastPasswordSet(LocalDate.of(2020, 1, 31));
		users.setRole("Customer");
		//users.setCustomer(2);
		renewRepo.save(users);
		
		
		Premium premium = new Premium();
		premium.setId(2);
		premium.setType("4-Wheeler");
		premium.setAge(12);
		premium.setModel("Santro GLS");
		premium.setAmount(3500);
		premium.setDepreciationRate(20);
		renewRepo.save(premium);
		*/
	}
}
