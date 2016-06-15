package com.capgemini.stockExchange;

import java.util.List;

import com.capgemini.entity.Stocks;

public interface StocksService {
	Stocks createStocks(Stocks stocks);
	List<Stocks> findStockByName(String stockName);
	List<Stocks> findStocksByDate(int stockDate);
}
