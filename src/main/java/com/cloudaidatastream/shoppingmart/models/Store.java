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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="STORE")
@EntityListeners(AuditingEntityListener.class)
public class Store extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private String street1;
	private String street2;
	private String landmark;
	private String city;
	private String state;
	private int pin;
	private boolean active;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
	private Set<ProductStock> productStock = new HashSet<ProductStock>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Set<ProductStock> getProductStock() {
		return productStock;
	}
	public void setProductStock(Set<ProductStock> productStock) {
		this.productStock = productStock;
	}
}
