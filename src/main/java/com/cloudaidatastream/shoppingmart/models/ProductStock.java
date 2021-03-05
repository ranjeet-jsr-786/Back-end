package com.cloudaidatastream.shoppingmart.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="PRODUCT_STOCK")
@EntityListeners(AuditingEntityListener.class)
public class ProductStock extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false, updatable=false, insertable=true)
	private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id", nullable=false, updatable=false, insertable=true)
	private Store store;
	private double quanity;
	private String unit;
	private String detail;
	private String other_info;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productStock", cascade = CascadeType.ALL)
	private Set<StockDelivered> productsDelivered = new HashSet<StockDelivered>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productStock", cascade = CascadeType.ALL)
	private Set<StockReceived> productsReceived = new HashSet<StockReceived>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Set<StockDelivered> getProductsDelivered() {
		return productsDelivered;
	}
	public void setProductsDelivered(Set<StockDelivered> productsDelivered) {
		this.productsDelivered = productsDelivered;
	}
	public Set<StockReceived> getProductsReceived() {
		return productsReceived;
	}
	public void setProductsReceived(Set<StockReceived> productsReceived) {
		this.productsReceived = productsReceived;
	}

}
