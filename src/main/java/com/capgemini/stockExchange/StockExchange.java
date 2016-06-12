package com.capgemini.stockExchange;

import java.util.List;

public interface StockExchange {
	public List<StockPrices> updateCurrentStockPrices(List<StockPrices> stockPricesList);
}
