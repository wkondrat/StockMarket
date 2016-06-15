package com.capgemini.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name="StocksWallet.findAll", query="SELECT s FROM StocksWallet s")
public class StocksWallet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	private Integer playerID;

	private String stockName;

	private Integer stockQuantity;

	public StocksWallet() {
	}
	
	public StocksWallet(Integer id, Integer playerID, String stockName, Integer stockQuantity) {
		this.id = id;
		this.playerID = playerID;
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
	}
	
//	public StocksWallet(Integer playerID, String stockName, Integer stockQuantity) {
//		this.playerID = playerID;
//		this.stockName = stockName;
//		this.stockQuantity = stockQuantity;
//	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlayerID() {
		return this.playerID;
	}

	public void setPlayerID(Integer playerID) {
		this.playerID = playerID;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Integer getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}