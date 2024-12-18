package com.project.fraud.detection.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.project.fraud.detection.v1.model.TransactionData;
import com.project.fraud.detection.v1.repository.TransactionRepository;


@Service
public class TransactionService {
	
	private final String url = "https://prepstripe.com/transaction_task_payloads.json";

	@Autowired
	private TransactionRepository transactionRepository;
	
	public void fetchAndSaveTransactions() {
		
		RestTemplate restTemplate = new RestTemplate();
		JsonNode transactions = restTemplate.getForObject(url,  JsonNode.class);
		
		// Loop through the JSON and save each transaction
		transactions.forEach(transaction -> {
			TransactionData data = new TransactionData();
			data.setTransactionId(transaction.get("transactionId").asText());
			data.setAmount(transaction.get("amount").asDouble());
			data.setAccountNumber(transaction.get("accountNumber").asText());
			data.setTransactionTime(transaction.get("transactionTime").asText());
            data.setIpAddress(transaction.get("ipAddress").asText());
            data.setCountry(transaction.get("location").get("country").asText());
            data.setCity(transaction.get("location").get("city").asText());
            data.setTransactionType(transaction.get("transactionType").asText());
            data.setRemarks(transaction.get("remarks").asText());
//            data.setIndiaIpRange(indiaIpRange);
            
			transactionRepository.save(data);
		});
	}
	
	
	
	public List<TransactionData> getAllTransactions() {
		return transactionRepository.findAll();
	}
	
	
	
	public List<TransactionData> getFlaggedTransactions(List<TransactionData> transactions) {
		return transactions.stream()
				.filter(transaction -> transaction.getAmount() > 100000)
				.collect(Collectors.toList());
	}
	
	
	
	public List<TransactionData> getFlaggedTransactionsByIp(List<TransactionData> transactions) {
			return transactions.stream()
					.filter(transaction -> !"India".equals(transaction.getCountry()))
					.collect(Collectors.toList());
	}
	
	
	
	public List<TransactionData> getFlaggedTransactionsByAccount(List<TransactionData> transactions) {
		List<String> blacklistedAccounts = List.of("123456", "9229520619"); // Hardcoded Blacklisted Accounts
		return transactions.stream()
				.filter(transaction -> blacklistedAccounts.contains(transaction.getAccountNumber()))
				.collect(Collectors.toList());
	}
	
	
//	public List<TransactionData> getFlaggedTransactionsByTime(List<TransactionData> transactions) {
//	    return transactions.stream()
//	            .filter(transaction -> {
//	                // Fetch transactions for the same account and check the time
//	                List<TransactionData> similarTransactions = transactionRepository.findTransactionsWithinFiveMinutes(transaction.getAccountNumber(), transaction.getTransactionTime());
//	                return similarTransactions.size() > 3;
//	            })
//	            .collect(Collectors.toList());
//	}

}
