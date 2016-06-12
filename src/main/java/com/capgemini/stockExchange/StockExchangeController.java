package com.capgemini.stockExchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stockPrices")
public class StockExchangeController {	
	
	@Autowired
	StockExchange stockExchange;
	
	@RequestMapping("/stockPrices")
    public List<StockPrices> getStockPrices() {
        return stockExchange.updateCurrentStockPrices();
    }
}