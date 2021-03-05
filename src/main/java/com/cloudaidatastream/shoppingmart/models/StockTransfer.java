package com.cloudaidatastream.shoppingmart.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="STOCK_DELIVERED")
@EntityListeners(AuditingEntityListener.class)
public class StockTransfer extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long product_id;
	private long from_store_id;
	private long to_store_id;
	private double quanity;
	private String unit;
	private Timestamp transfer;
	private String status;
	private String detail;
	private String other_info;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getFrom_store_id() {
		return from_store_id;
	}
	public void setFrom_store_id(long from_store_id) {
		this.from_store_id = from_store_id;
	}
	public long getTo_store_id() {
		return to_store_id;
	}
	public void setTo_store_id(long to_store_id) {
		this.to_store_id = to_store_id;
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
	public Timestamp getTransfer() {
		return transfer;
	}
	public void setTransfer(Timestamp transfer) {
		this.transfer = transfer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}	
}
