package com.capgemini.broker;

public class Transaction {
	long transactionID;
	String stockName;
	long stockQuantity;
	double stockPrice;
	double amount;
	
	public long getTransactionID() {
		return transactionID;
	}
	
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
	
	public String getStockName() {
		return stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public long getStockQuantity() {
		return stockQuantity;
	}
	
	public void setStockQuantity(long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public double getStockPrice() {
		return stockPrice;
	}
	
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
