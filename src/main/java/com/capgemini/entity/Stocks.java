package com.capgemini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
@NamedQuery(name="Stocks.findAll", query="SELECT s FROM Stocks s")
public class Stocks implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	private String stockName;
	private int stockDate;
	private double stockPrice;

	public Stocks() {
	}

	public Stocks(Integer id, String stockName, int stockDate, double stockPrice) {
		this.id = id;
		this.stockName = stockName;
		this.stockDate = stockDate;
		this.stockPrice = stockPrice;
	}
	
	public Stocks(String stockName, int stockDate, double stockPrice) {
		this.stockName = stockName;
		this.stockDate = stockDate;
		this.stockPrice = stockPrice;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "stockName", nullable = false, length = 20)
	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Column(name = "stockDate", nullable = false)
	public int getStockDate() {
		return this.stockDate;
	}

	public void setStockDate(int stockDate) {
		this.stockDate = stockDate;
	}

	@Column(name = "stockPrice", nullable = false, precision = 22, scale = 0)
	public double getStockPrice() {
		return this.stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

}
