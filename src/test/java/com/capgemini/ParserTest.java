package com.capgemini;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ParserTest {
	
	@Test
	public void testShouldParseListToStockPricesList() {
		//given
		Parser parser = new Parser();
		Reader reader = new Reader();
		reader.readFileCSV("dane.csv");
		List<String> listToParse = reader.getReadedStocksDataList();
		//when
		List<StockPrices> stockPrices = parser.parseList(listToParse);
		//then
		assertFalse(stockPrices.isEmpty());
		assertTrue(stockPrices.get(0) instanceof StockPrices);
	}
	
	@Test
	public void TestShouldReturnEmptyListWhenEmptyListWasTransferredToParse() {
		//given
		Parser parser = new Parser();
		List<String> emptylistToParse = new ArrayList<String>();
		//when
		List<StockPrices> stockPrices = parser.parseList(emptylistToParse);
		//then
		assertTrue(stockPrices.isEmpty());
	}

}
