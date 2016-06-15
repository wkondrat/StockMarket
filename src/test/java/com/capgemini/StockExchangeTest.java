package com.capgemini;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.stockExchange.StockExchange;
import com.capgemini.stockExchange.StockPrices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "Test-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StockExchangeTest {

	@Autowired
	StockExchange stockExchange;

	List<StockPrices> stockPrices;

	@Before
	public void beforeEach() {
		stockPrices = new ArrayList<StockPrices>();
		stockPrices.add(new StockPrices("STOCK1", 20130102, 1.1));
		stockPrices.add(new StockPrices("STOCK2", 20130102, 2.1));
		stockPrices.add(new StockPrices("STOCK1", 20130103, 1.2));
		stockPrices.add(new StockPrices("STOCK2", 20130103, 2.0));
		stockPrices.add(new StockPrices("STOCK3", 20130103, 3.0));
		stockPrices.add(new StockPrices("STOCK1", 20130104, 1.3));
		stockPrices.add(new StockPrices("STOCK2", 20130104, 2.2));
	}

	@Test
	public void testShouldReturnStockPricesForCurrentDate() {
		// given
		List<StockPrices> currentStockPrices;
		stockExchange.setStockPricesList(stockPrices);
		// when
		currentStockPrices = stockExchange.updateCurrentStockPrices();		
		// then
		assertEquals(currentStockPrices.size(), 2);
		assertEquals(currentStockPrices.get(0), stockPrices.get(0));
		assertEquals(currentStockPrices.get(1), stockPrices.get(1));
	}

	@Test
	public void testShouldUpdateCurrentDateSavedInStockExchange() {
		// given
		List<StockPrices> currentStockPrices;
		stockExchange.setStockPricesList(stockPrices);

		// when
		currentStockPrices = stockExchange.updateCurrentStockPrices();
		// then
		assertEquals(currentStockPrices.size(), 2);

		// when
		currentStockPrices = stockExchange.updateCurrentStockPrices();	
		// then
		assertEquals(currentStockPrices.size(), 3);
	}

	@Test(expected = NoSuchElementException.class)
	public void testShould() {
		// when
		stockExchange.updateCurrentStockPrices();
	}
}
