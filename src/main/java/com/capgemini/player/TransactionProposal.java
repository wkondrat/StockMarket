package com.capgemini.player;

public class TransactionProposal {
	Enum TransactionType;
	String stockName;
	long stockQuantity;
	double stockPrice;
	
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
	
	public Enum getTransactionType() {
		return TransactionType;
	}
	
	public void setTransactionType(Enum transactionType) {
		TransactionType = transactionType;
	}
	
}
