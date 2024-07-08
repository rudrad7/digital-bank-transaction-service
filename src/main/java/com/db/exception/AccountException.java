package com.db.exception;

import org.springframework.http.HttpStatus;

public class AccountException extends RuntimeException{
	public AccountException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public AccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public AccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public AccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public AccountException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	private String message;
	private HttpStatus httpStatus;
	

}
