package com.db.exception;

import org.springframework.http.HttpStatus;

public class TransactionException extends RuntimeException{
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	private String message;
	private HttpStatus httpStatus;
	
	public TransactionException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	

}
