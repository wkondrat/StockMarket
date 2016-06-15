package com.capgemini.broker;

import com.capgemini.entity.Transaction;

public interface TransactionService {
	Transaction findTransactionId(Integer idTransaction);
	Transaction createTransaction(Transaction transaction);
	Transaction updateTransaction(Transaction transaction);
}
