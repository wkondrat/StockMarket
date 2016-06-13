package com.capgemini;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.broker.StocksWallet;

public class StocksWalletTest {

	Map<String, Long> mapOfPlayerStocks;

	@Before
	public void beforeEach() {
		mapOfPlayerStocks = new HashMap<String, Long>();
		mapOfPlayerStocks.put("STOCK1", Long.valueOf(5));
		mapOfPlayerStocks.put("STOCK2", Long.valueOf(4));
		mapOfPlayerStocks.put("STOCK3", Long.valueOf(9));
	}

	@Test
	public void testShouldAddStocksToStocksWallet() {
		// given
		long playerID = 1;
		long numberOfStocksToAdd = 3;
		StocksWallet stocksWallet = new StocksWallet(playerID, mapOfPlayerStocks);
		// when
		stocksWallet.addStocks(playerID, "STOCK1", numberOfStocksToAdd);
		// then
		assertEquals(stocksWallet.getMapOfPlayerStocks().get("STOCK1"), Long.valueOf(8));
	}

	@Test
	public void testShouldSubtractStocksToStocksWallet() {
		// given
		long playerID = 1;
		long numberOfStocksToSubtract = 3;
		StocksWallet stocksWallet = new StocksWallet(playerID, mapOfPlayerStocks);
		// when
		stocksWallet.subtractStocks(playerID, "STOCK3", numberOfStocksToSubtract);
		// then
		assertEquals(stocksWallet.getMapOfPlayerStocks().get("STOCK3"), Long.valueOf(6));
	}

	@Test
	public void test() {
		// given
		long playerID = 1;
		StocksWallet stocksWallet = new StocksWallet(playerID, mapOfPlayerStocks);
		// when
		Map<String,Long> mapOfPlayerStocks = stocksWallet.getMapOfPlayerStocks();
	}
}
