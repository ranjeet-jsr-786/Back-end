package com.cloudaidatastream.shoppingmart.dto;

import java.util.HashSet;
import java.util.Set;

public class ProductStockDTO {

	private long id;
	private String product_code;
	private long store_id;
	private double quanity;
	private String unit;
	private String detail;
	private String other_info;
	private Set<ProductDeliveredDTO> productsDelivered = new HashSet<ProductDeliveredDTO>();
	private Set<ProductReceivedDTO> productsReceived = new HashSet<ProductReceivedDTO>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public long getStore_id() {
		return store_id;
	}
	public void setStore_id(long store_id) {
		this.store_id = store_id;
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
	public Set<ProductDeliveredDTO> getProductsDelivered() {
		return productsDelivered;
	}
	public void setProductsDelivered(Set<ProductDeliveredDTO> productsDelivered) {
		this.productsDelivered = productsDelivered;
	}
	public Set<ProductReceivedDTO> getProductsReceived() {
		return productsReceived;
	}
	public void setProductsReceived(Set<ProductReceivedDTO> productsReceived) {
		this.productsReceived = productsReceived;
	}
	

}
