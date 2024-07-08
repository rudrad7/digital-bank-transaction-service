package com.db.serviceImpl;

import com.db.entity.Transaction;
import com.db.exception.AccountException;
import com.db.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.db.communication.AccountService;
import com.db.dto.DepositMoney;
import com.db.exception.TransactionException;
import com.db.service.TransactionService;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	 private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	@Autowired
	private AccountService accountService;
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public ResponseEntity<String> depositMoney(DepositMoney depositMoney) throws TransactionException{
		logger.info("Enter into depositMoney :");
		logger.info("Request is : "+depositMoney.toString());
		return accountService.depositMoney(depositMoney);

	}

	@Override
	public ResponseEntity<String> withdrawMoney(DepositMoney withdrawMoney) throws AccountException{
		try {
			logger.info("Enter into withdrawMoney :");
			logger.info("Request is : " + withdrawMoney.toString());
			return accountService.withdrawMoney(withdrawMoney);
		}catch (Exception e){
			throw new AccountException(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<List<Transaction>> getTransactionList() {
		logger.info("Enter into getTransactionList ");
		try {
			List<Transaction> transactionList = transactionRepository.findAll();
			return new ResponseEntity<>(transactionList,HttpStatus.OK);
		}catch (Exception e){
			logger.error(e.getMessage());
			throw new TransactionException(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<List<Transaction>> getTransactionListByAccountNo(String accountNo) {
		logger.info("Enter into getTransactionListByAccountNo ");
		try {
			List<Transaction> all = transactionRepository.findByAccountNumber(accountNo);
			return new ResponseEntity<>(all,HttpStatus.OK);
		}catch (Exception e){
			logger.error(e.getMessage());
			throw new TransactionException(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

}
