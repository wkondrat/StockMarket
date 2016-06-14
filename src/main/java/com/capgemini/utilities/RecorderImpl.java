package com.capgemini.utilities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.Stocks;
import com.capgemini.repository.StockRepository;

@Service
@Transactional(readOnly = true)
public class RecorderImpl implements Recorder {

	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public Stocks createStocks(Stocks stocks) {
		stocks.setId(null);
		return stockRepository.save(stocks);
	}

	@Override
	public List<Stocks> findStockByName(String stockName) {
		return stockRepository.findStocksByName(stockName);
	}

	@Override
	public List<Stocks> findStocksByDate(int stockDate) {
		return stockRepository.findStocksByDate(stockDate);
	}
	
}
