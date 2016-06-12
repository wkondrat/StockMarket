package com.capgemini.stockExchange;

import org.springframework.stereotype.Repository;

@Repository
public class StockPrices {
	private String stockName;
	private int date;
	private double stockPrice;
	
	public StockPrices() {}
	
	public StockPrices(String stockName, int date, double price) {
		this.stockName = stockName;
		this.stockPrice = price;
		this.date = date;
	}
	
	public String getStockName() {
		return stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public int getDate() {
		return date;
	}
	
	public void setDate(int date) {
		this.date = date;
	}
	
	public double getStockPrice() {
		return stockPrice;
	}
	
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
}
