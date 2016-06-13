package com.capgemini.broker;

import java.util.List;

import com.capgemini.stockExchange.StockPrices;

public interface Broker {
	List<StockPrices> getTodaysStockPrices();
}
