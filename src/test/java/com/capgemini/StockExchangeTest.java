package com.capgemini;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.stockExchange.StockExchangeImpl;
import com.capgemini.stockExchange.StockPrices;
import com.capgemini.utilities.ParserImpl;
import com.capgemini.utilities.ReaderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "Test-context.xml")
public class StockExchangeTest {
	@Autowired
	ReaderImpl reader;
	@Autowired
	ParserImpl parser;
	@Autowired 
	StockExchangeImpl stockExchange;
	
	
	@Test
	public void testShouldCheckIfEachUpdateCurrentStockPricesListHasSameSize() {
		// given
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
