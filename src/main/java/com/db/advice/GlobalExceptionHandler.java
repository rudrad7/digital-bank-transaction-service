package com.db.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.db.exception.AccountException;
import com.db.exception.TransactionException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<String> handleGlobalException(TransactionException exception){
		return new ResponseEntity<String>(exception.getMessage(),exception.getHttpStatus());
	}
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<String> handleGlobalAccountException(AccountException exception){
		return new ResponseEntity<String>(exception.getMessage(),exception.getHttpStatus());
	}

}
