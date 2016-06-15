package com.capgemini.broker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.StocksWallet;
import com.capgemini.repository.StocksWalletRepository;

@Service
@Transactional(readOnly = true)
public class StockWalletServiceImpl implements StocksWalletService {
	
	@Autowired
	private StocksWalletRepository stocksWalletRepository;
	
	@Override
	public List<OwnedStocks> findPlayerStocks(Long playerID) {
		return stocksWalletRepository.findPlayerStocks(playerID);
	}

	@Override
	public OwnedStocks findPlayerSpecificStocks(Long playerID, String stockName) {
		return stocksWalletRepository.findPlayerSpecificStocks(playerID, stockName);
	}

	@Override
	public StocksWallet createStocksWallet(StocksWallet stocksWallet) {
		return stocksWalletRepository.save(stocksWallet);
	}

	@Override
	public StocksWallet updateStocksWallet(StocksWallet stocksWallet) {
		if(stocksWallet.getId().equals(null)){
			return null;
		}
		return stocksWalletRepository.save(stocksWallet);
	}
	
}
