package com.capgemini.stockExchange;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class StockExchangeImpl implements StockExchange {
	private Integer currentDate = null;
	private Iterator it;

	public List<StockPrices> updateCurrentStockPrices(List<StockPrices> stockPricesList) {
		List<StockPrices> currentStockPricesList = new ArrayList<StockPrices>();
		Set<Integer> sortedDateSet = createSortedSetOfStocksDate(stockPricesList);
		setCurrentDate(sortedDateSet);
		return createListWithCurrentStockPrices(stockPricesList, currentStockPricesList);
	}

	private List<StockPrices> createListWithCurrentStockPrices(List<StockPrices> stockPricesList,
			List<StockPrices> currentStockPricesList) {
		for (StockPrices i : stockPricesList) {
			if (i.date == currentDate) {
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
			sortedDateSet.add(i.date);
		}
		return sortedDateSet;
	}
}
