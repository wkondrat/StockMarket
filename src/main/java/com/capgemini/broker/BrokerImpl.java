package com.capgemini.broker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockExchange.StockExchange;
import com.capgemini.stockExchange.StockPrices;

@Service
public class BrokerImpl implements Broker {
	List<StockPrices> historicalListOfStocks = new ArrayList<StockPrices>();
	List<StockPrices> todaysListOfStocksPrices = new ArrayList<StockPrices>();
	Integer numberOfDaysInHistorical = null;
	
	@Autowired
	StockExchange stockExchange;

	public List<StockPrices> getHistoricalListOfStocks() {
		return historicalListOfStocks;
	}

	public void setHistoricalListOfStocks(List<StockPrices> historicalListOfStocks) {
		this.historicalListOfStocks = historicalListOfStocks;
	}

	@Override
	public List<StockPrices> getTodaysStockPrices() {
		List<StockPrices> todaysListOfStocksPrices = stockExchange.updateCurrentStockPrices();
		updateHistoricalListOfStocks(todaysListOfStocksPrices);
		return todaysListOfStocksPrices;
	}

	private void updateHistoricalListOfStocks(List<StockPrices> todaysListOfStocksPrices) {
		Set<Integer> sortedDateSet = new HashSet<Integer>();
		for (StockPrices i : todaysListOfStocksPrices) {
			historicalListOfStocks.add(i);
		}
		numberOfDaysInHistorical = calculateDaysInHistoricalListOfStocksPrices(sortedDateSet);
	}

	private Integer calculateDaysInHistoricalListOfStocksPrices(Set<Integer> sortedDateSet) {
		for (StockPrices i : historicalListOfStocks) {
			sortedDateSet.add(i.getDate());
		}
		return sortedDateSet.size();
	}

}
