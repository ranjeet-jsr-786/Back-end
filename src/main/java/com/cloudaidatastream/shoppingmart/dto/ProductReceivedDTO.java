package com.cloudaidatastream.shoppingmart.dto;

import java.sql.Timestamp;

public class ProductReceivedDTO {

	private long id;
	private long stock_id;
	private long refrence_id;
	private String refrence_type;
	private String product_code;
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

	public long getStock_id() {
		return stock_id;
	}

	public void setStock_id(long stock_id) {
		this.stock_id = stock_id;
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

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
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
}
