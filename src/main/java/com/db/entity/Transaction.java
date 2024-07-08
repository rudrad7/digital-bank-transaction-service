package com.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Integer transactionId;
	@Column(name="customer_id")
	private String customerId;
	@Column(name="account_id")
	private String accountId;

	@Column(name="account_number")
	private String accountNumber;
	@Column(name="transaction_amount")
	private double transactionAmount;
	@Column(name="balance")
	private double balance;
	@Column(name="transaction_type")
	private String transactionType;
	@Column(name="transaction_date")
	private String transactionDate;
	@Column(name="transaction_remark")
	private String transactionRemark;

	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transaction(Integer transactionId, String customerId, String accountId,String accountNumber, double transactionAmount,double balance,
			String transactionType, String transactionDate, String transactionRemark) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.accountId = accountId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionRemark = transactionRemark;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}


	public Integer getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public double getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getTransactionRemark() {
		return transactionRemark;
	}


	public void setTransactionRemark(String transactionRemark) {
		this.transactionRemark = transactionRemark;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
