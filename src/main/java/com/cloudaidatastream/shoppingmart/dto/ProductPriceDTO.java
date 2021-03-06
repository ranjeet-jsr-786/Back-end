
package com.cloudaidatastream.shoppingmart.dto;

import java.io.Serializable;

public class ProductPriceDTO  implements Serializable {

	private long id;
	private String product_id;
	private String unit;
	private double base_price;
	private String base_price_unit;
	private double sale_price;
	private String sale_price_unit;
	private double purchase_price;
	private String purchage_price_unit;
	private double discount;
	private boolean active;
	private String status;
	private String other_info;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getBase_price() {
		return base_price;
	}
	public void setBase_price(double base_price) {
		this.base_price = base_price;
	}
	public String getBase_price_unit() {
		return base_price_unit;
	}
	public void setBase_price_unit(String base_price_unit) {
		this.base_price_unit = base_price_unit;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public String getSale_price_unit() {
		return sale_price_unit;
	}
	public void setSale_price_unit(String sale_price_unit) {
		this.sale_price_unit = sale_price_unit;
	}
	public double getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(double purchase_price) {
		this.purchase_price = purchase_price;
	}
	public String getPurchage_price_unit() {
		return purchage_price_unit;
	}
	public void setPurchage_price_unit(String purchage_price_unit) {
		this.purchage_price_unit = purchage_price_unit;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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

}
