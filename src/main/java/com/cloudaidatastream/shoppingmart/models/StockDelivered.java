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
@Table(name="STOCK_DELIVERED")
@EntityListeners(AuditingEntityListener.class)
public class StockDelivered extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stock_id", nullable=false, updatable=false, insertable=true)
	private ProductStock productStock;
	private long refrence_id;
	private String refrence_type;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="product_id", referencedColumnName = "id")
	private Product product ;
	private double quanity;
	private String unit;
	private Timestamp delivered_date;
	private String delivered_by;
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

	public Timestamp getDelivered_date() {
		return delivered_date;
	}

	public void setDelivered_date(Timestamp delivered_date) {
		this.delivered_date = delivered_date;
	}

	public String getDelivered_by() {
		return delivered_by;
	}

	public void setDelivered_by(String delivered_by) {
		this.delivered_by = delivered_by;
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
}
