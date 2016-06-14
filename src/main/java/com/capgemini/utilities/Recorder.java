package com.capgemini.utilities;

import java.util.List;

import com.capgemini.entity.Stocks;

public interface Recorder {
	Stocks createStocks(Stocks stocks);
	List<Stocks> findStockByName(String stockName);
	List<Stocks> findStocksByDate(int stockDate);
}
