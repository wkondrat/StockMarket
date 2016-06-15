package com.capgemini.utilities;

import java.util.List;

import com.capgemini.stockExchange.StockPrices;

public interface RecorderService {
	void sendDataToDatabase (List<StockPrices> stockPrices);
}
