package com.capgemini.stockExchange;

public class StockPrices {
	String stockName;
	int date;
	double stockPrice;
	
	public String getStockName() {
		return stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public Integer getDate() {
		return date;
	}
	
	public void setDate(Integer date) {
		this.date = date;
	}
	
	public Double getStockPrice() {
		return stockPrice;
	}
	
	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}
}
