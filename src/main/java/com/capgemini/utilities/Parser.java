package com.capgemini.utilities;

import java.util.List;

import com.capgemini.stockExchange.StockPrices;

public interface Parser {
	public List<StockPrices> parseList(List<String> listToParse);
}
