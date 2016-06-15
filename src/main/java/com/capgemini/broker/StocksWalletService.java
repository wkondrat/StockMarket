package com.capgemini.broker;

import java.util.List;

import com.capgemini.entity.StocksWallet;
import com.capgemini.entity.Transaction;

public interface StocksWalletService {
	List<OwnedStocks> findPlayerStocks(Long playerID);
	OwnedStocks findPlayerSpecificStocks(Long playerID, String stockName);
	StocksWallet createStocksWallet(StocksWallet stocksWallet);
	StocksWallet updateStocksWallet(StocksWallet stocksWallet);
}
