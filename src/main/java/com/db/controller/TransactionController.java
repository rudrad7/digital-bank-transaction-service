package com.db.controller;

import com.db.entity.Transaction;
import com.db.exception.AccountException;
import com.db.exception.TransactionException;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.db.dto.DepositMoney;
import com.db.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService service;
	
	@PostMapping("/deposit")
	public ResponseEntity<String> depositMoney(@RequestBody DepositMoney depositMoney){
		return service.depositMoney(depositMoney);
	}

	@PostMapping("/withdraw")
	public ResponseEntity<String> withdrawMoney(@RequestBody DepositMoney withdrawMoney) throws AccountException ,TransactionException{
		return service.withdrawMoney(withdrawMoney);
	}

	@GetMapping("/getList")
	public ResponseEntity<List<Transaction>> getTransactionList(){
		return service.getTransactionList();
	}

	@GetMapping("/getList/{accountNo}")
	public ResponseEntity<List<Transaction>> getTransactionListByAccountNo(@PathVariable String accountNo){
		return  service.getTransactionListByAccountNo(accountNo);
	}

}
