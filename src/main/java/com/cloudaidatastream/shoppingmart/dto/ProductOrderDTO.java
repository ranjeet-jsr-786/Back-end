package com.cloudaidatastream.shoppingmart.dto;

public class ProductOrderDTO {	   
    private long  id;
    private String orderNumber;
    private String product_id;
    private double amount;     	
    private double price;      	
    private int quanity;    		
    private String quanity_unit;
    private String status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
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
