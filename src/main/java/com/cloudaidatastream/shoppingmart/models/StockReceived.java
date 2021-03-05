package com.cloudaidatastream.shoppingmart.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="STOCK_RECEIVED")
@EntityListeners(AuditingEntityListener.class)
public class StockReceived extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stock_id", nullable=false, updatable=false, insertable=true)
	private ProductStock productStock;
	private long refrence_id;
	private String refrence_type;
	@ManyToOne
	@JoinColumn(name="product_id", referencedColumnName = "id")
	private Product product ;
	private double quanity;
	private String unit;
	private Timestamp received_date;
	private String received_by;
	private String detail;
	private String other_info;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public long getRefrence_id() {
		return refrence_id;
	}

	public void setRefrence_id(long refrence_id) {
		this.refrence_id = refrence_id;
	}

	public String getRefrence_type() {
		return refrence_type;
	}

	public void setRefrence_type(String refrence_type) {
		this.refrence_type = refrence_type;
	}
	
	public double getQuanity() {
		return quanity;
	}

	public void setQuanity(double quanity) {
		this.quanity = quanity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getOther_info() {
		return other_info;
	}

	public void setOther_info(String other_info) {
		this.other_info = other_info;
	}

	public ProductStock getProductStock() {
		return productStock;
	}

	public void setProductStock(ProductStock productStock) {
		this.productStock = productStock;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Timestamp getReceived_date() {
		return received_date;
	}

	public void setReceived_date(Timestamp received_date) {
		this.received_date = received_date;
	}

	public String getReceived_by() {
		return received_by;
	}

	public void setReceived_by(String received_by) {
		this.received_by = received_by;
	}
}
