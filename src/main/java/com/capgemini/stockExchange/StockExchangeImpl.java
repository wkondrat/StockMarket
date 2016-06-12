package com.capgemini.stockExchange;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class StockExchangeImpl implements StockExchange {
	private List<StockPrices> stockPricesList = new ArrayList<StockPrices>();
	private Iterator it;
	private Integer currentDate = null;
	
	public List<StockPrices> getStockPricesList() {
		return stockPricesList;
	}
	
	@Override
	public void setStockPricesList(List<StockPrices> stockPricesList) {
		this.stockPricesList = stockPricesList;
	}
	
	@Override
	public List<StockPrices> updateCurrentStockPrices() {
		if (stockPricesList.isEmpty()) {
			//throw new StockPriceNotInitialisedException();
		}
		Set<Integer> sortedDateSet = createSortedSetOfStocksDate(stockPricesList);
		setCurrentDate(sortedDateSet);
		return createListWithCurrentStockPrices();
	}

	private List<StockPrices> createListWithCurrentStockPrices() {
		List<StockPrices> currentStockPricesList = new ArrayList<StockPrices>();
		for (StockPrices i : stockPricesList) {
			if (i.getDate() == currentDate) {
				currentStockPricesList.add(i);
			}
		}
		return currentStockPricesList;
	}

	private void setCurrentDate(Set<Integer> sortedDateSet) {
		if (currentDate != null) {
			currentDate = (Integer) it.next();
		}
		if (currentDate == null) {
			it = sortedDateSet.iterator();
			currentDate = (Integer) it.next();
		}
	}

	private Set<Integer> createSortedSetOfStocksDate(List<StockPrices> stockPricesList) {
		Set<Integer> sortedDateSet = new TreeSet<Integer>();
		for (StockPrices i : stockPricesList) {
			sortedDateSet.add(i.getDate());
		}
		return sortedDateSet;
	}
}
