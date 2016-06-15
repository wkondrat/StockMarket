package com.capgemini.broker;

import java.util.List;

import com.capgemini.entity.StocksWallet;

public interface StocksWalletService {
	List<OwnedStocks> findPlayerStocks(Integer playerID);
	OwnedStocks findPlayerSpecificStocks(Integer playerID, String stockName);
	StocksWallet createStocksWallet(StocksWallet stocksWallet);
	StocksWallet updateStocksWallet(StocksWallet stocksWallet);
}
