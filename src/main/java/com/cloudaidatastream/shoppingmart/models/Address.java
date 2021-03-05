package com.cloudaidatastream.shoppingmart.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//@Getter
//@Setter
@Entity
@Table(name="ADDRESS")
@EntityListeners(AuditingEntityListener.class)
public class Address extends Auditable<String> {
	
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO) 
    private long  id;
    private String postboxNo;

    private String street1;    
    private String street2;  
    private String landmark; 
    private String city;  
    private String state;  
    private String pin;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPostboxNo() {
		return postboxNo;
	}
	public void setPostboxNo(String postboxNo) {
		this.postboxNo = postboxNo;
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
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}  
}
