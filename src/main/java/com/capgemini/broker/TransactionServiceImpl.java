package com.capgemini.broker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.Transaction;
import com.capgemini.repository.TransactionRepository;

@Service
@Transactional(readOnly = true)
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public Transaction findTransactionId(Integer idTransaction) {
		return transactionRepository.findTransactionId(idTransaction);
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	@Override
	public Transaction updateTransaction(Transaction transaction) {
		if(transaction.getIdTransaction().equals(null)){
			return null;
		}
		return transactionRepository.save(transaction);
	}

}
