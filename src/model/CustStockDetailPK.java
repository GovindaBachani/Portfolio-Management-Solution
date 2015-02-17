package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cust_stock_details database table.
 * 
 */
@Embeddable
public class CustStockDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cust_id")
	private int custId;

	@Column(name="stock_tickr")
	private String stockTickr;

	public CustStockDetailPK() {
	}
	public int getCustId() {
		return this.custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getStockTickr() {
		return this.stockTickr;
	}
	public void setStockTickr(String stockTickr) {
		this.stockTickr = stockTickr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustStockDetailPK)) {
			return false;
		}
		CustStockDetailPK castOther = (CustStockDetailPK)other;
		return 
			(this.custId == castOther.custId)
			&& this.stockTickr.equals(castOther.stockTickr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.custId;
		hash = hash * prime + this.stockTickr.hashCode();
		
		return hash;
	}
}