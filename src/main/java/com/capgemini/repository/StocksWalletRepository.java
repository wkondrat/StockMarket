package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.broker.OwnedStocks;
import com.capgemini.entity.StocksWallet;

public interface StocksWalletRepository extends JpaRepository<StocksWallet, Integer>{
	
	@Query("select stocksWallet from StocksWallet stocksWallet where stocksWallet.playerID like :playerID")
	List<OwnedStocks> findPlayerStocks(@Param("playerID") Long playerID);
	
	@Query("select stocksWallet from StocksWallet stocksWallet where stocksWallet.playerID like :playerID and stocksWallet.stockName like :stockName")
	OwnedStocks findPlayerSpecificStocks(@Param("playerID") Long playerID, @Param("stockName") String stockName);
	
}