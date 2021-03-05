package com.cloudaidatastream.shoppingmart.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cloudaidatastream.shoppingmart.enums.PaymentMode;
import com.cloudaidatastream.shoppingmart.enums.PaymentStatus;
import com.cloudaidatastream.shoppingmart.enums.ReferenceType;

@Entity
@Table(name="PAYMENT")
@EntityListeners(AuditingEntityListener.class)
public class Payment extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String refrence_id;
	@Enumerated(EnumType.STRING)
	private ReferenceType refrence_type;
	@Enumerated(EnumType.STRING)
	private PaymentMode payment_mode;
	private double amount_paid;
	private String transaction_id;
	private String detail;
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	private String other_info;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRefrence_id() {
		return refrence_id;
	}

	public void setRefrence_id(String refrence_id) {
		this.refrence_id = refrence_id;
	}

	public ReferenceType getRefrence_type() {
		return refrence_type;
	}

	public void setRefrence_type(ReferenceType refrence_type) {
		this.refrence_type = refrence_type;
	}

	public PaymentMode getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(PaymentMode payment_mode) {
		this.payment_mode = payment_mode;
	}

	public double getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(double amount_paid) {
		this.amount_paid = amount_paid;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getOther_info() {
		return other_info;
	}

	public void setOther_info(String other_info) {
		this.other_info = other_info;
	}
}
