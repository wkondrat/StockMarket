package com.capgemini.player;

import java.util.Map;

import com.capgemini.bank.Currency;
import com.capgemini.broker.Transaction;

public interface Player {
	Map<Currency, Double> checkAccount();
	Map<String, Long> checkStocksWallet();
	Transaction createOrder(int playerID, TransactionProposal transactionProposal);
}
