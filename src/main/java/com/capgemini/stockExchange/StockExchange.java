package com.capgemini.stockExchange;

import java.util.List;

public interface StockExchange {
	List<StockPrices> updateCurrentStockPrices();
	void setStockPricesList(List<StockPrices> stockPricesList);
}
