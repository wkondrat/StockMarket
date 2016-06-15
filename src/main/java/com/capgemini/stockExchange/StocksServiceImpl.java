package com.capgemini.stockExchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.entity.Stocks;
import com.capgemini.repository.StocksRepository;

public class StocksServiceImpl implements StocksService {
	
	@Autowired
	StocksRepository stocksRepository;
	
	@Override
	public Stocks createStocks(Stocks stocks) {
		return stocksRepository.save(stocks);
	}

	@Override
	public List<Stocks> findStockByName(String stockName) {
		return stocksRepository.findStocksByName(stockName);
	}

	@Override
	public List<Stocks> findStocksByDate(int stockDate) {
		return stocksRepository.findStocksByDate(stockDate);
	}
}
