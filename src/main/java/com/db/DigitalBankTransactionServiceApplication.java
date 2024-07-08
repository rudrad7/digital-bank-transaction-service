package com.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalBankTransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankTransactionServiceApplication.class, args);
		System.out.println("Transaction service started on : 8082");
	}

}
