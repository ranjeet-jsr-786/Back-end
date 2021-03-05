package com.cloudaidatastream.shoppingmart.dto;

public class InvoiceDetailDTO {
	
	private long id;
	private long invoice_id;
	private String product_id;
	private String product_name;
	private double quanity;
	private String quanity_unit;
	private double base_price;
	private double tax1;
	private double tax2;
	private double tax3;
	private double amount;
	private double discount;
	private double net_amount;
	private double total_amount;
	private String status;
	private String other_info;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
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
	public double getBase_price() {
		return base_price;
	}
	public void setBase_price(double base_price) {
		this.base_price = base_price;
	}
	public double getTax1() {
		return tax1;
	}
	public void setTax1(double tax1) {
		this.tax1 = tax1;
	}
	public double getTax2() {
		return tax2;
	}
	public void setTax2(double tax2) {
		this.tax2 = tax2;
	}
	public double getTax3() {
		return tax3;
	}
	public void setTax3(double tax3) {
		this.tax3 = tax3;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getNet_amount() {
		return net_amount;
	}
	public void setNet_amount(double net_amount) {
		this.net_amount = net_amount;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
}
