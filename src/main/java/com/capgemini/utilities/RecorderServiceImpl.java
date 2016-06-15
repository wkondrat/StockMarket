package com.capgemini.utilities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.Stocks;
import com.capgemini.repository.StocksRepository;
import com.capgemini.stockExchange.StockPrices;

@Service
@Transactional(readOnly = true)
public class RecorderServiceImpl implements RecorderService {

	@Autowired
	private StocksRepository stockRepository;
	
	@Override
	public Stocks createStocks(Stocks stocks) {
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
	
	@Override
	public void sendDataToDatabase (List<StockPrices> stockPrices) {
		for (StockPrices i : stockPrices) {
			Stocks stocks = new Stocks(null, i.getStockName(), i.getDate(), i.getStockPrice());
			stockRepository.save(stocks);
		}
	}
}
