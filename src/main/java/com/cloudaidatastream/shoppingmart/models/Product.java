package com.cloudaidatastream.shoppingmart.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Entity
@Table(name="PRODUCT")
@EntityListeners(AuditingEntityListener.class)
public class Product extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private long  id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category  category;	
    @Column(unique = true)
    private String  code;        	
    private String  name;        	
    private boolean  active;      	
    private double  mrp_price;      
    private String  price_unit;     
    private String  size;       		
    private String  size_unit;      
    private String  color;       	
    private String  type;       		
    private String  manufacturer;	
    private Date    manufacturing_date;
    private Date    expiry_date; 	
    private String  hsn_code; 		
    private String  detail;       	
    private String  batch_number; 	
    private String  other_info; 		
    private byte[]  image;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductStock> productStock = new HashSet<ProductStock>();
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductPrice> productPrice = new HashSet<ProductPrice>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public double getMrp_price() {
		return mrp_price;
	}
	public void setMrp_price(double mrp_price) {
		this.mrp_price = mrp_price;
	}
	public String getPrice_unit() {
		return price_unit;
	}
	public void setPrice_unit(String price_unit) {
		this.price_unit = price_unit;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSize_unit() {
		return size_unit;
	}
	public void setSize_unit(String size_unit) {
		this.size_unit = size_unit;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Date getManufacturing_d() {
		return manufacturing_date;
	}
	public void setManufacturing_d(Date manufacturing_d) {
		this.manufacturing_date = manufacturing_d;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getHsn_code() {
		return hsn_code;
	}
	public void setHsn_code(String hsn_code) {
		this.hsn_code = hsn_code;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getBatch_number() {
		return batch_number;
	}
	public void setBatch_number(String batch_number) {
		this.batch_number = batch_number;
	}
	public String getOther_info() {
		return other_info;
	}
	public void setOther_info(String other_info) {
		this.other_info = other_info;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Date getManufacturing_date() {
		return manufacturing_date;
	}
	public void setManufacturing_date(Date manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}
	public Set<ProductStock> getProductStock() {
		return productStock;
	}
	public void setProductStock(Set<ProductStock> productStock) {
		this.productStock = productStock;
	}
	public Set<ProductPrice> getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Set<ProductPrice> productPrice) {
		this.productPrice = productPrice;
	}       	
    
}
