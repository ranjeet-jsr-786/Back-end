package com.cloudaidatastream.shoppingmart.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="ORDERED_CANCEL")
@EntityListeners(AuditingEntityListener.class)
public class OrderCancel extends Auditable<String> {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String ordered_product_id;
	private double amount;
	private double quanity;
	private String quanity_unit;
	private String status;
	private String other_info;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrdered_product_id() {
		return ordered_product_id;
	}

	public void setOrdered_product_id(String ordered_product_id) {
		this.ordered_product_id = ordered_product_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public String getOther_info() {
		return other_info;
	}

	public void setOther_info(String other_info) {
		this.other_info = other_info;
	}
}
