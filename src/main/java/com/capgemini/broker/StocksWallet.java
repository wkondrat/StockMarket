package com.capgemini.broker;

import java.util.Map;

public class StocksWallet {
	long playerID;
	Map<String,Long> mapOfPlayerStocks;
	
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
		
	}
}
