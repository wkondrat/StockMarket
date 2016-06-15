package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.entity.Stocks;

public interface StocksRepository extends JpaRepository<Stocks, Integer>{
	
	@Query("select stocks from Stocks stocks where upper(stocks.stockName) like concat(upper(:stockName), '%')")
	public List<Stocks> findStocksByName(@Param("stockName") String stockName);
	
	@Query("select stocks from Stocks stocks where upper(stocks.stockDate) like concat(upper(:stockDate), '%')")
	public List<Stocks> findStocksByDate(@Param("stockDate") int stockDate);
	
}
