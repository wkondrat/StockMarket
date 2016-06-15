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

	@Lob
	private long playerID;

	private String stockName;

	@Lob
	private Long stockQuantity;

	public StocksWallet() {
	}
	
	public StocksWallet(Integer id, Long playerID, String stockName, Long stockQuantity) {
		this.id = id;
		this.playerID = playerID;
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
	}
	
	public StocksWallet(Long playerID, String stockName, Long stockQuantity) {
		this.playerID = playerID;
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPlayerID() {
		return this.playerID;
	}

	public void setPlayerID(Long playerID) {
		this.playerID = playerID;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Long getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}