package com.cloudaidatastream.shoppingmart.enums;

public enum ReferenceType {

	ON_DELIVERY("ON_DELIVERY"), RETURNED("RETURNED"), PURCHASE("PURCHASE"), SALE("SALE"), MAINTENANCE("MAINTENANCE"), OTHERS("OTHERS"), MISCELLANEOUS("MISCELLANEOUS");

    private String status;

    ReferenceType(String status){
        this.status = status;
    }
}
