package com.capgemini.broker;

import java.util.Map;

public class StocksWalletPrev {
	long playerID;
	Map<String,Long> mapOfPlayerStocks;
	
	public StocksWalletPrev() {}
	
	public StocksWalletPrev(long playerID, Map<String,Long> mapOfPlayerStocks) {
		this.playerID = playerID;
		this.mapOfPlayerStocks = mapOfPlayerStocks;
	}
	
	public long getPlayerID() {
		return playerID;
	}
	
	public void setPlayerID(long playerID) {
		this.playerID = playerID;
	}
	
	public Map<String, Long> getMapOfPlayerStocks() {
		return mapOfPlayerStocks;
	}
	
	public void setMapOfPlayerStocks(Map<String, Long> mapOfPlayerStocks) {
		this.mapOfPlayerStocks = mapOfPlayerStocks;
	}
	
	public void addStocks(long playerID, String stockName, long stocksQuantity) {
		stocksQuantity = (mapOfPlayerStocks.get(stockName) + stocksQuantity);
		mapOfPlayerStocks.put(stockName, stocksQuantity);
	}
	
	public void subtractStocks(long playerID, String stockName, long stocksQuantity) {
		stocksQuantity = (mapOfPlayerStocks.get(stockName) - stocksQuantity);
		// throw NotEnoughStocksException
		mapOfPlayerStocks.put(stockName, stocksQuantity);
	}
}
