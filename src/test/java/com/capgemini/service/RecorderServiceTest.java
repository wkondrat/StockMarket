package com.capgemini.service;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.stockExchange.StockPrices;
import com.capgemini.utilities.Parser;
import com.capgemini.utilities.Reader;
import com.capgemini.utilities.RecorderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RecorderServiceTest {

	@Autowired
	private RecorderService recorder;
	
	@Autowired
	private Reader reader;
	
	@Autowired
	private Parser parser;
	
	@Test
	public void testShouldAddAllStocksToDatabase() throws IOException {
		// given
		reader.readFileCSV("dane.csv");
		List<StockPrices> stocksPrices = parser.parseList(reader.getReadStocksDataList());
		// when
		recorder.sendDataToDatabase(stocksPrices);

	}

}
