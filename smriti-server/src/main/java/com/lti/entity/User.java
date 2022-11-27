package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.lti.service.UserService;

@Entity
@Table(name = "TBL_USER")
@NamedQuery(name = "is-user-present", query = "select count(u.emailId) from User u where u.emailId = :em")
@NamedQuery(name = "fetch-login", query = ("select u from User u where u.emailId = :email and u.password = :password"))
@NamedQuery(name = "fetch-user-using-otp", query = ("select u from User u where u.otp = :otp"))
@NamedQuery(name = "fetch-user-using-email", query = ("select u from User u where u.emailId = :email"))
public class User {

	@Id
	@SequenceGenerator(name = "user_id", initialValue = 1, allocationSize = 1)
	@GeneratedValue
	private int id;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	@Column(name = "last_password_set")
	private LocalDate lastPasswordSet;

	@Column(name = "createdOn")
	private LocalDate createdOn;

	@Column(name = "lastLogin")
	private LocalDateTime lastLogin;

	@Column(name = "otp")
	private String otp;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer; // can be null in case of admin as admin will not have any customer_id
	// but in case of customer it will not be null as it is primary key and every
	// customer will have one

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getLastPasswordSet() {
		return lastPasswordSet;
	}

	public void setLastPasswordSet(LocalDate lastPasswordSet) {
		this.lastPasswordSet = lastPasswordSet;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = UserService.getHashedString(password);

	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
