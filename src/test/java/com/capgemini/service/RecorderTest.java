package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.entity.Stocks;
import com.capgemini.stockExchange.StockPrices;
import com.capgemini.utilities.Parser;
import com.capgemini.utilities.Reader;
import com.capgemini.utilities.RecorderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RecorderTest {

	@Autowired
	private RecorderService recorder;
	
	@Autowired
	private Reader reader;
	
	@Autowired
	private Parser parser;
	
	@Ignore
	@Test
	public void testShouldAddStockToDatabase() {
		// given
		final String stockName = "testName";
		final int stockDate = 12345678;
		final double stockPrice = 1.2;
		Stocks stocks = new Stocks(null, stockName, stockDate, stockPrice);
		recorder.createStocks(stocks);
		// when
		List<Stocks> stock = recorder.findStockByName(stockName);
		// then
		assertNotNull(stock);
		assertFalse(stock.isEmpty());
		assertEquals(stockDate, stock.get(0).getStockDate());		
	}
	
	@Ignore
	@Test
	public void testShouldFindStockInDatabaseByDate() {
		// given
		final String stockName = "testName";
		final int stockDate = 12345678;
		final double stockPrice = 1.2;
		Stocks stocks = new Stocks(null, stockName, stockDate, stockPrice);
		recorder.createStocks(stocks);
		// when
		List<Stocks> stock = recorder.findStocksByDate(stockDate);
		// then
		assertNotNull(stock);
		assertFalse(stock.isEmpty());
		assertEquals(stockDate, stock.get(0).getStockDate());		
	}
	

	@Test
	public void testShouldAddAllStocksToDatabase() throws IOException {
		// given
		reader.readFileCSV("dane.csv");
		List<StockPrices> stocksPrices = parser.parseList(reader.getReadStocksDataList());
		// when
		recorder.sendDataToDatabase(stocksPrices);
		// then
	}

}
