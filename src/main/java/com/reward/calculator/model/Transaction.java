package com.reward.calculator.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;

/**
 * Entity class for transaction table
 * 
 * @author atulsingh
 *
 */
@Getter
@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long transactionId;

	@Column(name = "transaction_value")
	private Float transactionValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "transaction_date")
	private Date transactionDate;

	@Column(name = "transaction_description")
	private String transactionDescription;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	public Transaction(Long transactionId, Float transactionValue, Date transactionDate, String transactionDescription,
			Customer customer) {
		super();
		this.transactionId = transactionId;
		this.transactionValue = transactionValue;
		this.transactionDate = transactionDate;
		this.transactionDescription = transactionDescription;
		this.customer = customer;
	}
	
	public Transaction() {
		
	}
	
	
	

}
