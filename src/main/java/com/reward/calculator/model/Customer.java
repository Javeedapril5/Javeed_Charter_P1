package com.reward.calculator.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

/**
 * Entity class for customer table
 * @author atulsingh
 *
 */
@Getter
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long customerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "contact_number")
	private Long contactNumber;
	
	@OneToMany(mappedBy = "customer")
	private List<Transaction> transactions;
	
	
}
