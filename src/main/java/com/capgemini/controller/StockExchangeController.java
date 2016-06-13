package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.stockExchange.StockExchange;
import com.capgemini.stockExchange.StockPrices;

@Controller
//@ResponseBody
public class StockExchangeController {	
	
	@Autowired
	StockExchange stockExchange;
	
	@RequestMapping(value = "/stockprices", method = RequestMethod.GET)
    public ResponseEntity<List<StockPrices>> getStockPrices() {
		List<StockPrices> stocks = stockExchange.updateCurrentStockPrices();
        return new ResponseEntity<List<StockPrices>>(stocks, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public StockPrices getStocks() {
		StockPrices stock = new StockPrices();
		stock.setDate(123);
		stock.setStockName("alfa");
		stock.setStockPrice(3.2);
		return stock;
	}
}