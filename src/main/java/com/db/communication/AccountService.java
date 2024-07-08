package com.db.communication;

import org.springframework.http.ResponseEntity;

import com.db.dto.DepositMoney;

public interface AccountService {

	ResponseEntity<String> depositMoney(DepositMoney depositMoney);

	ResponseEntity<String> withdrawMoney(DepositMoney withdrawMoney);
}
