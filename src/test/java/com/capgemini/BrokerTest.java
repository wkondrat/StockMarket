package com.capgemini;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

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

import com.capgemini.broker.Broker;
import com.capgemini.stockExchange.StockExchange;
import com.capgemini.stockExchange.StockPrices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "Test-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BrokerTest {

	@Autowired
	StockExchange stockExchange;
	@Autowired
	Broker broker;

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
	public void testShouldGetStockPricesList() {
		// given
		stockExchange.setStockPricesList(stockPrices);
		List<StockPrices> todaysStockPricesList;
		//when
		todaysStockPricesList = broker.getTodaysStockPrices();
		//then
		assertFalse(todaysStockPricesList.isEmpty());
	}
	
	@Test
	public void testShouldUpdateStockPricesList() {
		// given
		stockExchange.setStockPricesList(stockPrices);
		List<StockPrices> beforeStockPricesList;
		List<StockPrices> todaysStockPricesList;
		//when
		beforeStockPricesList = broker.getTodaysStockPrices();
		todaysStockPricesList = broker.getTodaysStockPrices();
		//then
		assertFalse(todaysStockPricesList.isEmpty());
		assertNotEquals(beforeStockPricesList,todaysStockPricesList);
		assertEquals(beforeStockPricesList.get(0).getStockName(),todaysStockPricesList.get(0).getStockName());
		assertNotEquals(beforeStockPricesList.get(0).getDate(),todaysStockPricesList.get(0).getDate());
		
	}

}
