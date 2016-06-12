package com.capgemini;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class StockExchangeTest {

	@Test
	public void testShouldCheckIfEachUpdateCurrentStockPricesListHasSameSize() {
		// given
		Parser parser = new Parser();
		Reader reader = new Reader();
		StockExchange stockExchange = new StockExchange();
		reader.readFileCSV("dane.csv");
		List<String> listToParse = reader.getReadedStocksDataList();
		List<StockPrices> stockPrices = parser.parseList(listToParse);
		// when
		List<StockPrices> currentStockPrices = stockExchange.updateCurrentStockPrices(stockPrices);
		int sizeOfCurrentStockPricesList = currentStockPrices.size();
		//then
		assertFalse(currentStockPrices.isEmpty());
		assertEquals(sizeOfCurrentStockPricesList, stockExchange.updateCurrentStockPrices(stockPrices).size());
	}
	
	@Test
	public void testShouldCheckIfEachUpdateCurrentStockPricesListHasDifferentValues() {
		// given
		Parser parser = new Parser();
		Reader reader = new Reader();
		StockExchange stockExchange = new StockExchange();
		reader.readFileCSV("dane.csv");
		List<String> listToParse = reader.getReadedStocksDataList();
		List<StockPrices> stockPrices = parser.parseList(listToParse);
		// when
		List<StockPrices> currentStockPrices = stockExchange.updateCurrentStockPrices(stockPrices);
		Integer firstDateInCurrentStockPricesList = currentStockPrices.get(0).getDate();
		currentStockPrices = stockExchange.updateCurrentStockPrices(stockPrices);
		Integer secondDateInCurrentStockPricesList = currentStockPrices.get(0).getDate();
		//then
		assertFalse(currentStockPrices.isEmpty());
		assertNotEquals(firstDateInCurrentStockPricesList, secondDateInCurrentStockPricesList);
	}
}
