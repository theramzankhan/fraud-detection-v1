package com.project.fraud.detection.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fraud.detection.v1.model.TransactionData;
import com.project.fraud.detection.v1.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/save-transactions")
	public String saveTransactions() {
		transactionService.fetchAndSaveTransactions();
		return "Transaction saved successfully!";
	}
	
	@GetMapping("/get-transactions")
	public List<TransactionData> getTransactions() {
		List<TransactionData> transactions = transactionService.getAllTransactions();
		return transactions;
	}
	
	@GetMapping("/flaggedByAmount")
	public ResponseEntity<List<TransactionData>> getFlaggedTransactions() {
		List<TransactionData> flaggedTransactions = transactionService.getFlaggedTransactions(getTransactions());
		return ResponseEntity.ok(flaggedTransactions);
	}
	
	@GetMapping("/flaggedByIp")
	public ResponseEntity<List<TransactionData>> getFlaggedTransactionsByIp() {
		List<TransactionData> flaggedTransactions = transactionService.getFlaggedTransactionsByIp(getTransactions());
		return ResponseEntity.ok(flaggedTransactions);
	}
	
	@GetMapping("/flaggedByAccount")
	public ResponseEntity<List<TransactionData>> getFlaggedTransactionsByAccount() {
		List<TransactionData> flaggedTransactions = transactionService.getFlaggedTransactionsByAccount(getTransactions());
		return ResponseEntity.ok(flaggedTransactions);
	}
	
	
//	@GetMapping("/flaggedByTime")
//	public ResponseEntity<List<TransactionData>> getFlaggedTransactionsByTime() {
//	    List<TransactionData> flaggedTransactions = transactionService.getFlaggedTransactionsByTime(getTransactions());
//	    return ResponseEntity.ok(flaggedTransactions);
//	}

}

