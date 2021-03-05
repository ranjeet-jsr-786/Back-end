package com.cloudaidatastream.shoppingmart.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="SUPPLIER")
@EntityListeners(AuditingEntityListener.class)
public class Supplier extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private String contact_name;
	private String firm_name;
	private String licence_number;
	private long product_category;
	private String email;
	private String phone;
	private String mobile;
	private String alternate_mobile;
	private String detail;
	private String other_info;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getFirm_name() {
		return firm_name;
	}

	public void setFirm_name(String firm_name) {
		this.firm_name = firm_name;
	}

	public String getLicence_number() {
		return licence_number;
	}

	public void setLicence_number(String licence_number) {
		this.licence_number = licence_number;
	}

	public long getProduct_category() {
		return product_category;
	}

	public void setProduct_category(long product_category) {
		this.product_category = product_category;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAlternate_mobile() {
		return alternate_mobile;
	}

	public void setAlternate_mobile(String alternate_mobile) {
		this.alternate_mobile = alternate_mobile;
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
}
