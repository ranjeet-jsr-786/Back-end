package com.cloudaidatastream.shoppingmart.enums;

public enum AddressType {
	RESIDENCE("RESIDENCE"), OFFICE("OFFICE"), SHIPPING("SHIPPING"), PERMANENT("PERMANENT"), TEMPORARY("TEMPORARY");

    private String addressType;

    AddressType(String addressType) {
        this.addressType = addressType;
    }
}
