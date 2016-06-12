package com.capgemini;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.stockExchange.StockPrices;
import com.capgemini.utilities.ParserImpl;
import com.capgemini.utilities.ReaderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "Test-context.xml")
public class ParserTest {
	
	@Autowired
	private ParserImpl parser;
	
	@Autowired
	private ReaderImpl reader;
	
	@Test
	public void testShouldParseListToStockPricesList() {
		//given
		reader.readFileCSV("dane.csv");
		List<String> listToParse = reader.getReadedStocksDataList();
		//when
		List<StockPrices> stockPrices = parser.parseList(listToParse);
		//then
		assertFalse(stockPrices.isEmpty());
		assertTrue(stockPrices.get(0) instanceof StockPrices);
	}
	
	@Ignore
	@Test
	public void TestShouldReturnEmptyListWhenEmptyListWasTransferredToParse() {
		//given
		List<String> emptylistToParse = new ArrayList<String>();
		//when
		List<StockPrices> stockPrices = parser.parseList(emptylistToParse);
		//then
		assertTrue(stockPrices.isEmpty());
	}

}
