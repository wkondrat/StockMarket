package com.capgemini.stockExchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.Stocks;
import com.capgemini.repository.StocksRepository;

@Service
@Transactional(readOnly = true)
public class StocksServiceImpl implements StocksService {
	
	@Autowired
	private StocksRepository stocksRepository;
	
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
