package com.db.dto;

public class DepositResponseDto {
    private String accountNo;
    private double balance;
    private String accountId;
    private String message;

    public DepositResponseDto() {
    }

    public DepositResponseDto(String accountNo, String accountId, String message,double balance) {
        this.accountNo = accountNo;
        this.accountId = accountId;
        this.message = message;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


