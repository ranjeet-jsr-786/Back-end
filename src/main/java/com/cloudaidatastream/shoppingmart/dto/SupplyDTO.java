package com.cloudaidatastream.shoppingmart.dto;

public class SupplyDTO {

	private long id;
	private long supplier_id;
	private long purchase_order_id;
	private String product_id;
	private double amount;
	private double price;
	private double quanity;
	private String quanity_unit;
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(long supplier_id) {
		this.supplier_id = supplier_id;
	}

	public long getPurchase_order_id() {
		return purchase_order_id;
	}

	public void setPurchase_order_id(long purchase_order_id) {
		this.purchase_order_id = purchase_order_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuanity() {
		return quanity;
	}

	public void setQuanity(double quanity) {
		this.quanity = quanity;
	}

	public String getQuanity_unit() {
		return quanity_unit;
	}

	public void setQuanity_unit(String quanity_unit) {
		this.quanity_unit = quanity_unit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
