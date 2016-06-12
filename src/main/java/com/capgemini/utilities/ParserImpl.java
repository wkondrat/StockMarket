package com.capgemini.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capgemini.stockExchange.StockPrices;

@Component
public class ParserImpl implements Parser {
	private List<StockPrices> stockPricesList = new ArrayList<StockPrices>();
	
	public List<StockPrices> getStockPricesList() {
		return stockPricesList;
	}

	public void setStockPricesList(List<StockPrices> stockPricesList) {
		this.stockPricesList = stockPricesList;
	}

	public List<StockPrices> parseList(List<String> listToParse) {
		String cvsSplitBy = ",";
		for (String i : listToParse) {
			String[] stocksData = i.split(cvsSplitBy);
			StockPrices stockPrices = createStockPrice(stocksData);
			stockPricesList.add(stockPrices);
		}
		return stockPricesList;
	}
	
	private StockPrices createStockPrice(String[] stocks) {
		StockPrices stockPrices = new StockPrices();
		stockPrices.setStockName(stocks[0]);
		stockPrices.setDate(Integer.parseInt(stocks[1]));
		stockPrices.setStockPrice(Double.parseDouble(stocks[2]));
		return stockPrices;
	}
}
