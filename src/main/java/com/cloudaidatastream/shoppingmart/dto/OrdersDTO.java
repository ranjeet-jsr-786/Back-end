package com.cloudaidatastream.shoppingmart.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class OrdersDTO {	
	   
    private String order_num;    
    private long customer_id; 
    private String detail;       
    private double amount;       
    private Timestamp order_date;
    private String type;         
    private String status;       
    private String other_info;
	private Set<ProductOrderDTO> productOrders;
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOther_info() {
		return other_info;
	}
	public void setOther_info(String other_info) {
		this.other_info = other_info;
	}
	public Set<ProductOrderDTO> getProductOrders() {
		return productOrders;
	}
	public void setProductOrders(Set<ProductOrderDTO> productOrders) {
		this.productOrders = productOrders;
	}

}
