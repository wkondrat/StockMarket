package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.entity.Stocks;
import com.capgemini.utilities.Recorder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RecorderTest {

	@Autowired
	private Recorder recorder;

	@Test
	public void test() {
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
		assertEquals(stockDate, stock.get(0).getStockData());
		
	}

}
