package com.capgemini.utilities;

import java.util.List;

import com.capgemini.entity.Stocks;
import com.capgemini.stockExchange.StockPrices;

public interface RecorderService {
	Stocks createStocks(Stocks stocks);
	List<Stocks> findStockByName(String stockName);
	List<Stocks> findStocksByDate(int stockDate);
	
	void sendDataToDatabase (List<StockPrices> stockPrices);
}
