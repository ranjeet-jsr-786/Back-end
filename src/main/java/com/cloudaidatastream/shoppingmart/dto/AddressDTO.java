package com.cloudaidatastream.shoppingmart.dto;


import com.cloudaidatastream.shoppingmart.enums.AddressType;
import com.cloudaidatastream.shoppingmart.models.Address;

import lombok.*;

/**
 * Created by Hi on 31-01-2018.
 */
//@Getter
//@Setter
//@Getter
//@Setter
public class AddressDTO {

	private String street1;
	
	private String street2;
	
    private String postboxNo;

    private String landmark;

    private String zipcode;

    private String phoneNumber;

    private String city;

	private String state;
    
	private String addressType;
	
	private boolean active;

    public AddressDTO() {}

    public String getPostboxNo() {
        return postboxNo;
    }

    public void setPostboxNo(String postboxNo) {
        this.postboxNo = postboxNo;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
