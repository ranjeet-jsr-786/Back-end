package com.cloudaidatastream.shoppingmart.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cloudaidatastream.shoppingmart.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ORDERED_ITEMS")
@EntityListeners(AuditingEntityListener.class)
public class ProductOrder  extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private long  id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", nullable=false, updatable=false, insertable=true)
    @JsonBackReference
    private Orders orderNumber;
    private String product_id;
    private double amount;     	
    private double price;      	
    private int quanity;    		
    private String quanity_unit;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Orders getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Orders orderNumber) {
		this.orderNumber = orderNumber;
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
	public ProductStatus getStatus() {
		return status;
	}
	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	} 
}
