package com.capgemini;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.stockExchange.StockPrices;
import com.capgemini.utilities.Parser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "Test-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ParserTest {
	
	@Autowired
	private Parser parser;
	
	List<String> listToParse;
	
	@Before
	public void beforeEach() {
		listToParse = new ArrayList<String>();
		listToParse.add("STOCK1,20130102,1.1");
		listToParse.add("STOCK2,20130102,2.1");
		listToParse.add("STOCK1,20130103,1.2");
		listToParse.add("STOCK2,20130103,2.0");
		listToParse.add("STOCK3,20130103,3.0");
		listToParse.add("STOCK1,20130104,1.3");
		listToParse.add("STOCK2,20130104,2.2");
	}
	
	@Test
	public void testShouldParseListToStockPricesList() {
		//given
		List<StockPrices> stockPrices;
		//when
		stockPrices = parser.parseList(listToParse);
		//then
		assertFalse(stockPrices.isEmpty());
		assertTrue(stockPrices.get(0) instanceof StockPrices);
	}
	
	@Test
	public void TestShouldReturnEmptyList() {
		//given
		List<String> emptylistToParse = new ArrayList<String>();
		List<StockPrices> stockPrices;
		//when
		stockPrices = parser.parseList(emptylistToParse);
		//then
		assertTrue(stockPrices.isEmpty());
	}

}
