package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cust_stock_details database table.
 * 
 */
@Entity
@Table(name="cust_stock_details")
@NamedQuery(name="CustStockDetail.findAll", query="SELECT c FROM CustStockDetail c")
public class CustStockDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustStockDetailPK id;

	@Column(name="current_price_of_stock")
	private float currentPriceOfStock;

	@Column(name="number_of_stocks")
	private int numberOfStocks;

	public CustStockDetail() {
	}

	public CustStockDetailPK getId() {
		return this.id;
	}

	public void setId(CustStockDetailPK id) {
		this.id = id;
	}

	public float getCurrentPriceOfStock() {
		return this.currentPriceOfStock;
	}

	public void setCurrentPriceOfStock(float currentPriceOfStock) {
		this.currentPriceOfStock = currentPriceOfStock;
	}

	public int getNumberOfStocks() {
		return this.numberOfStocks;
	}

	public void setNumberOfStocks(int numberOfStocks) {
		this.numberOfStocks = numberOfStocks;
	}

}