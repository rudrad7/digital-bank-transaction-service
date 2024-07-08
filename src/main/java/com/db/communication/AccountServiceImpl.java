package com.db.communication;

import java.time.LocalDateTime;
import java.util.Objects;

import com.db.dto.DepositResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.db.commonUtils.TransactionUtil;
import com.db.dto.DepositMoney;
import com.db.entity.Transaction;
import com.db.exception.AccountException;
import com.db.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TransactionRepository repository;


    @Override
    public ResponseEntity<String> depositMoney(DepositMoney depositMoney) throws AccountException {
        logger.info("Enter into depositMoney :");
        try {
            String url = TransactionUtil.DEPOSIT_URL;
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<DepositMoney> request = new HttpEntity<>(depositMoney, headers);

            ResponseEntity<DepositResponseDto> response = restTemplate.exchange(url, HttpMethod.POST, request, DepositResponseDto.class);

            logger.info("MY_RESPONSE : " + response.toString());
            if (response.getStatusCode() == HttpStatus.OK) {
                logger.info("Response: " + response.getBody());
                Transaction transaction = new Transaction();
                transaction.setTransactionAmount(depositMoney.getTransactionAmount());
                transaction.setTransactionDate(String.valueOf(LocalDateTime.now()));
                transaction.setTransactionRemark(depositMoney.getTransactionMessage());
                transaction.setTransactionType(TransactionUtil.DEPOSIT);
                transaction.setAccountId(Objects.requireNonNull(response.getBody()).getAccountId());
                transaction.setAccountNumber(response.getBody().getAccountNo());
                transaction.setBalance(response.getBody().getBalance());
                repository.save(transaction);
            } else {
                System.out.println();
                logger.info("Request failed with status code: " + response.getStatusCode());
            }
        } catch (Exception e) {

        }
        return new ResponseEntity<>("Money Deposit Successfully !", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> withdrawMoney(DepositMoney withdrawMoney) throws AccountException {
        logger.info("Enter into withdrawMoney :");
        try {
            String url = TransactionUtil.WITHDRAW_URL;
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<DepositMoney> request = new HttpEntity<>(withdrawMoney, headers);

            ResponseEntity<DepositResponseDto> response = restTemplate.exchange(url, HttpMethod.POST, request, DepositResponseDto.class);

            logger.info("MY_RESPONSE : " + response.toString());
            if (response.getStatusCode() == HttpStatus.OK) {
                logger.info("Response: " + response.getBody());
                Transaction transaction = new Transaction();
                transaction.setTransactionAmount(withdrawMoney.getTransactionAmount());
                transaction.setTransactionDate(String.valueOf(LocalDateTime.now()));
                transaction.setTransactionRemark(withdrawMoney.getTransactionMessage());
                transaction.setTransactionType(TransactionUtil.WITHDRAW);
                transaction.setAccountId(Objects.requireNonNull(response.getBody()).getAccountId());
                transaction.setAccountNumber(response.getBody().getAccountNo());
                transaction.setBalance(response.getBody().getBalance());
                repository.save(transaction);
            } else {
                System.out.println();
                logger.info("Request failed with status code: " + response.getStatusCode());
            }

            return new ResponseEntity<>("Money Withdraw Successfully !", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new AccountException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
