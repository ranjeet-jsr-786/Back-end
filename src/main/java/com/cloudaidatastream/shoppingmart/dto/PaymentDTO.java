package com.cloudaidatastream.shoppingmart.dto;

public class PaymentDTO {

	private long id;
	private String refrence_id;
	private String refrence_type;
	private String payment_mode;
	private double amount_paid;
	private String transaction_id;
	private String detail;
	private String status;
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

	public String getRefrence_type() {
		return refrence_type;
	}

	public void setRefrence_type(String refrence_type) {
		this.refrence_type = refrence_type;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
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
