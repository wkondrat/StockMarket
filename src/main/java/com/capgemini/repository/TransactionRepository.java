package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	@Query("select transaction from Transaction transaction where transaction.idTransaction like :idTransaction")
	Transaction findTransactionId(@Param("idTransaction") Integer idTransaction);
	
}
