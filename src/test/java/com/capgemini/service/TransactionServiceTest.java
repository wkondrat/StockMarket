package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.broker.TransactionService;
import com.capgemini.entity.Transaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTransactionTest-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TransactionServiceTest {

	@Autowired
	private TransactionService transactionService;
	
	@Test
	public void testShouldCreateTransaction() {
		// given
		final String stockName = "testName";
		final Integer stockQuantity = 10;
		final double stockPrice = 1.2;
		final double amount = 14;
		Date startDate = new Date();
		Transaction transaction = new Transaction(null, stockName, stockQuantity, stockPrice, amount, startDate, null);
		// when
		Transaction createdTransaction = transactionService.createTransaction(transaction);
		// then
		assertNotNull(createdTransaction);
	}
	
	@Test
	public void testShouldFindTransactionByID() {
		// given
		final String stockName = "testName";
		final Integer stockQuantity = 10;
		final double stockPrice = 1.2;
		final double amount = 14;
		Date startDate = new Date();
		Transaction transaction = new Transaction(null, stockName, stockQuantity, stockPrice, amount, startDate, null);
		Transaction createdTransaction = transactionService.createTransaction(transaction);
		// when
		Transaction transactionFounded = transactionService.findTransactionId(createdTransaction.getIdTransaction());
		// then
		assertNotNull(transactionFounded);
		assertEquals(stockQuantity, transactionFounded.getStockQuantity());
	}

}
