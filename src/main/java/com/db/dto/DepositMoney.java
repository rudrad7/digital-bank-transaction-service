package com.db.dto;

public class DepositMoney {
	
	private String accountNumber;
	private double transactionAmount;
	private String transactionMessage;
	
	
	public DepositMoney(String accountNumber, double transactionAmount,String transactionMessage) {
		super();
		this.accountNumber = accountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionMessage = transactionMessage;
	}
	
	public DepositMoney() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionMessage() {
		return transactionMessage;
	}

	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}

	@Override
	public String toString() {
		return "DepositMoney [accountNumber=" + accountNumber + ", transactionAmount=" + transactionAmount
				+ ", transactionMessage=" + transactionMessage + "]";
	}
	
	
	
	

}
