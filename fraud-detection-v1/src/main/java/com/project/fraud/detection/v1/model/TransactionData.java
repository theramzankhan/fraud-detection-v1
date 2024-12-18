package com.project.fraud.detection.v1.model;


import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class TransactionData {
	@Id
	private String transactionId;
    private String accountNumber;
    private double amount;
    private String transactionTime;
    private String ipAddress;

    // Location fields
    private String country;
    private String city;

    private String transactionType;
    private String remarks;
    
   
    
    public TransactionData() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public TransactionData(String transactionId, String accountNumber, double amount, String transactionTime,
			String ipAddress, String country, String city, String transactionType, String remarks) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionTime = transactionTime;
		this.ipAddress = ipAddress;
		this.country = country;
		this.city = city;
		this.transactionType = transactionType;
		this.remarks = remarks;
	}
    
    
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	@Override
	public String toString() {
		return "TransactionData [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", amount="
				+ amount + ", transactionTime=" + transactionTime + ", ipAddress=" + ipAddress + ", country=" + country
				+ ", city=" + city + ", transactionType=" + transactionType + ", remarks=" + remarks + "]";
	}
    
}
