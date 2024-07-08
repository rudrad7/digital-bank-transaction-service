package com.db.service;

import com.db.entity.Transaction;
import org.springframework.http.ResponseEntity;

import com.db.dto.DepositMoney;

import java.util.List;

public interface TransactionService {

	ResponseEntity<String> depositMoney(DepositMoney depositMoney);

    ResponseEntity<String> withdrawMoney(DepositMoney withdrawMoney);

    ResponseEntity<List<Transaction>> getTransactionList();

    ResponseEntity<List<Transaction>> getTransactionListByAccountNo(String accountNo);
}
